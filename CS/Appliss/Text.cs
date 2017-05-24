using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Appliss
{
    public partial class Text : Form
    {
        public Text()
        {
            InitializeComponent();
        }

        private void Text_Load(object sender, EventArgs e)
        {
            but_ent.Select();//初次显示窗体时选中按钮
        }

        private void Text_TextChanged(object sender, EventArgs e)
        {
            labNum.Text = textBoxs.Text.Length.ToString();
        }


    }
}
