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
    public partial class Register : Form
    {
        public Register()
        {
            InitializeComponent();
        }

        private void butRegister_Click(object sender, EventArgs e)
        {
            String nameInfo = @"^[a-zA-Z]\\w{5,17}$";
            String name = txtname.Text;

            String pwdInfo = @"^[a-zA-Z0-9]{6,16}$";
            String pwd1 = txtpwd1.Text;


        }
    }
}
