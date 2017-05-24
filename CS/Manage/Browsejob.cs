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
    public partial class Browsejob : Form 
    {
        public Browsejob()
        {
            InitializeComponent();
        }
        //定义数据集对象ds用于保存查询结果的结果集
        DataSet ds;
        static String connStr = "server=.;database=PersonMIS;uid=sa;pwd=system";
        SqlConnection conn = new SqlConnection(connStr);

        private void Browsejob_Load(object sender, EventArgs e)
        {
            conn.Open();
            String sql = "select JobID as 编号,JobName as 工种名称,Remark as 描述 from jobinfo" ;
            SqlDataAdapter sda = new SqlDataAdapter(sql,conn);
            ds = new DataSet();
            ds.Clear();
            sda.Fill(ds,"job");
            dataGrid.DataSource = ds.Tables[0].DefaultView;




        }
        //在DataGrid 中当前单元格发生变化时，将对应的工种名称显示在DataGrid标题中
        private void dataGrid_CurrentCellChanged(object sender, EventArgs e)
        {
         

        }

        ModifyJob modifyjob;
        private void but_updata_Click(object sender, EventArgs e)
        {
            if (dataGrid.CurrentCell != null)
            {
                modifyjob = new ModifyJob(); 
            }
        }
    }
}
