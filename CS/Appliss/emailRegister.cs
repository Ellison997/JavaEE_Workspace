using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;
namespace Appliss
{
    public partial class emailRegister : Form
    {
        String connStr = "server=.;database=stu;uid=sa;pwd=system";
        public emailRegister()
        {
            InitializeComponent();
        }

        private void emailRegister_Load(object sender, EventArgs e)
        {

        }

        private void but_login_Click(object sender, EventArgs e)
        {
            //注册用户
            SqlConnection conn = new SqlConnection(connStr);
            String sql = string.Format("insert into users(username,userpwd,truename) values('{0}','{1}','{2}')", text_account.Text, text_pwd.Text, text_name.Text);
            SqlCommand cmd = new SqlCommand(sql, conn);

            conn.Open();
            int count = 0;
            count = cmd.ExecuteNonQuery();

            conn.Close();
            if (count > 0)
            {
                MessageBox.Show("注册成功！");
            }
            else
            {

                MessageBox.Show("注册失败！");
            }
        }

        private void but_enter_Click(object sender, EventArgs e)
        {
            //登录验证用户
            DialogResult result=DialogResult.No;
            SqlConnection conn = new SqlConnection(connStr);
            String sql = string.Format("select count(*) from users where username='{0}' and userpwd='{1}'",text_account.Text,text_pwd.Text);
            SqlCommand cmd = new SqlCommand(sql, conn);

            conn.Open();
            int count = 0;
            count = Convert.ToInt32(cmd.ExecuteScalar());
            conn.Close();
            if (count>0)
            {
                Register rs = new Register();
                this.Hide();
                rs.ShowDialog();//将窗体显示为对话框
                this.Close();

            }
            else
            {
                //提示框
                MessageBox.Show("没有找到，再重新注册吧，哈哈哈！","提示",MessageBoxButtons.YesNo,MessageBoxIcon.Exclamation,MessageBoxDefaultButton.Button1);
                if (result==DialogResult.Yes)
                {
                    Application.Exit();
                }
            }
        }

        private void but_show_Click(object sender, EventArgs e)
        {
            //显示信息
            SqlConnection conn = new SqlConnection(connStr);
            String sql = "select* from users";
            SqlCommand cmd = new SqlCommand(sql, conn);

            conn.Open();
            
            List<User> list=new List<User>();
            SqlDataReader sdr = cmd.ExecuteReader();
            while (sdr.Read())
            {
                User user = new User();
                user.Uid = Convert.ToInt32(sdr[0].ToString());
                user.Username = sdr[1].ToString();
                user.Userpwd = sdr[2].ToString();
                user.Truename = sdr[3].ToString();
                list.Add(user);


            }
            conn.Close();

            dgvShow.DataSource = list;



        }

        private void emailRegister_KeyDown(object sender, KeyEventArgs e)
        {
            lalKey.Text = "您所按的键为:" + e.KeyCode + "," + e.Modifiers;
        }

        

        private void emailRegister_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button==MouseButtons.Left)
            {
                lblButton.Text = "左键!";
            }
            else if (e.Button==MouseButtons.Right)
            {
                lblButton.Text = "右键!";
            }
            else if (e.Button==MouseButtons.Middle)
            {
                lblButton.Text="中键！";
            }

            lblButton.Text += ",鼠标按键次数:" + e.Clicks;


        }

        private void emailRegister_MouseMove(object sender, MouseEventArgs e)
        {

            labMousePosition.Text = "当前鼠标的位置为(" + e.X + "," + e.Y + ")";
        }

        private void lnKBaidu_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            //超链接，不会
            lnKBaidu.LinkVisited = true;
            lnKBaidu.Text.Substring(3, 13);
            
        }
    }
}
