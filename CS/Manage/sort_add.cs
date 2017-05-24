using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace Manage
{
    public partial class sort_add : Form
    {
        String connStr = "server=.;database=PersonMIS;uid=sa;pwd=system";
        public sort_add()
        {
            InitializeComponent();
        }

        private void but_submit_Click(object sender, EventArgs e)
        {
            if (text_name.Text.Trim()=="")
            {
                MessageBox.Show("请输入工种名称！","提示");
            }
            else
            {
                String sqltemp = string.Format("select *from jobinfo where JobName='{0}'",text_name.Text.Trim());
                SqlConnection conn = new SqlConnection(connStr);
                conn.Open();
                SqlCommand cmd = new SqlCommand(sqltemp, conn);
                if (cmd.ExecuteScalar()!=null)
                {
                    MessageBox.Show("工种名称重复，请重新输入！","提示");
                }
                else
                {
                    String sql = string.Format("insert into jobinfo(JobName,Remark) values('{0}','{1}')",text_name.Text.Trim(),text_describe.Text.Trim());
                    cmd.CommandText = sql;
                    int count = 0;
                    count=cmd.ExecuteNonQuery();
                    if (count>0)
                    {
                        MessageBox.Show("添加工种成功！","提示");
                    }
                    else
                    {
                        MessageBox.Show("添加失败！");
                    }
                    text_name.Clear();//从文本框中清除所有文本
                    text_describe.Clear();
                
                }
                conn.Close();

            }

        }

        private void but_cancel_Click(object sender, EventArgs e)
        {

            this.Close();

        }
    }
}
