using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Manage
{
    public partial class FormMain : Form
    {
        public FormMain()
        {
            InitializeComponent();
        }

        private void 添加工种ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            sort_add sa = new sort_add();
            sa.ShowDialog();
        }

        private void 浏览工种ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Browsejob bj = new Browsejob();
            bj.ShowDialog();
        }
    }
}
