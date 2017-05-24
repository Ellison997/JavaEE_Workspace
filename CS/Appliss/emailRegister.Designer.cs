namespace Appliss
{
    partial class emailRegister
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.text_account = new System.Windows.Forms.TextBox();
            this.text_pwd = new System.Windows.Forms.TextBox();
            this.text_name = new System.Windows.Forms.TextBox();
            this.textBox4 = new System.Windows.Forms.TextBox();
            this.but_login = new System.Windows.Forms.Button();
            this.but_enter = new System.Windows.Forms.Button();
            this.but_show = new System.Windows.Forms.Button();
            this.dgvShow = new System.Windows.Forms.DataGridView();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.labMousePosition = new System.Windows.Forms.Label();
            this.lblButton = new System.Windows.Forms.Label();
            this.lalKey = new System.Windows.Forms.Label();
            this.lnKBaidu = new System.Windows.Forms.LinkLabel();
            this.butText = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dgvShow)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(56, 33);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "账号：";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(56, 72);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "密码：";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(56, 107);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(41, 12);
            this.label3.TabIndex = 2;
            this.label3.Text = "姓名：";
            // 
            // text_account
            // 
            this.text_account.Location = new System.Drawing.Point(92, 30);
            this.text_account.Name = "text_account";
            this.text_account.Size = new System.Drawing.Size(124, 21);
            this.text_account.TabIndex = 3;
            // 
            // text_pwd
            // 
            this.text_pwd.Location = new System.Drawing.Point(92, 69);
            this.text_pwd.Name = "text_pwd";
            this.text_pwd.Size = new System.Drawing.Size(124, 21);
            this.text_pwd.TabIndex = 4;
            // 
            // text_name
            // 
            this.text_name.Location = new System.Drawing.Point(92, 104);
            this.text_name.Name = "text_name";
            this.text_name.Size = new System.Drawing.Size(124, 21);
            this.text_name.TabIndex = 5;
            // 
            // textBox4
            // 
            this.textBox4.Enabled = false;
            this.textBox4.Location = new System.Drawing.Point(231, 30);
            this.textBox4.Name = "textBox4";
            this.textBox4.Size = new System.Drawing.Size(81, 21);
            this.textBox4.TabIndex = 6;
            this.textBox4.Text = "@126.com";
            // 
            // but_login
            // 
            this.but_login.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.but_login.Location = new System.Drawing.Point(58, 145);
            this.but_login.Name = "but_login";
            this.but_login.Size = new System.Drawing.Size(75, 23);
            this.but_login.TabIndex = 7;
            this.but_login.Text = "注册";
            this.but_login.UseVisualStyleBackColor = true;
            this.but_login.Click += new System.EventHandler(this.but_login_Click);
            // 
            // but_enter
            // 
            this.but_enter.Location = new System.Drawing.Point(141, 145);
            this.but_enter.Name = "but_enter";
            this.but_enter.Size = new System.Drawing.Size(75, 23);
            this.but_enter.TabIndex = 8;
            this.but_enter.Text = "登录";
            this.but_enter.UseVisualStyleBackColor = true;
            this.but_enter.Click += new System.EventHandler(this.but_enter_Click);
            // 
            // but_show
            // 
            this.but_show.Location = new System.Drawing.Point(231, 144);
            this.but_show.Name = "but_show";
            this.but_show.Size = new System.Drawing.Size(75, 23);
            this.but_show.TabIndex = 9;
            this.but_show.Text = "查询";
            this.but_show.UseVisualStyleBackColor = true;
            this.but_show.Click += new System.EventHandler(this.but_show_Click);
            // 
            // dgvShow
            // 
            this.dgvShow.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvShow.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvShow.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.Column2,
            this.Column3,
            this.Column4});
            this.dgvShow.Location = new System.Drawing.Point(318, 30);
            this.dgvShow.Name = "dgvShow";
            this.dgvShow.RowHeadersVisible = false;
            this.dgvShow.RowTemplate.Height = 23;
            this.dgvShow.Size = new System.Drawing.Size(364, 138);
            this.dgvShow.TabIndex = 10;
            // 
            // Column1
            // 
            this.Column1.DataPropertyName = "uid";
            this.Column1.HeaderText = "编号";
            this.Column1.Name = "Column1";
            this.Column1.Visible = false;
            // 
            // Column2
            // 
            this.Column2.DataPropertyName = "username";
            this.Column2.HeaderText = "账号";
            this.Column2.Name = "Column2";
            // 
            // Column3
            // 
            this.Column3.DataPropertyName = "userpwd";
            this.Column3.HeaderText = "密码";
            this.Column3.Name = "Column3";
            // 
            // Column4
            // 
            this.Column4.DataPropertyName = "truename";
            this.Column4.HeaderText = "姓名";
            this.Column4.Name = "Column4";
            // 
            // labMousePosition
            // 
            this.labMousePosition.AutoSize = true;
            this.labMousePosition.Location = new System.Drawing.Point(58, 243);
            this.labMousePosition.Name = "labMousePosition";
            this.labMousePosition.Size = new System.Drawing.Size(0, 12);
            this.labMousePosition.TabIndex = 11;
            // 
            // lblButton
            // 
            this.lblButton.AutoSize = true;
            this.lblButton.Location = new System.Drawing.Point(256, 243);
            this.lblButton.Name = "lblButton";
            this.lblButton.Size = new System.Drawing.Size(0, 12);
            this.lblButton.TabIndex = 12;
            // 
            // lalKey
            // 
            this.lalKey.AutoSize = true;
            this.lalKey.Location = new System.Drawing.Point(454, 243);
            this.lalKey.Name = "lalKey";
            this.lalKey.Size = new System.Drawing.Size(0, 12);
            this.lalKey.TabIndex = 13;
            // 
            // lnKBaidu
            // 
            this.lnKBaidu.AutoSize = true;
            this.lnKBaidu.Location = new System.Drawing.Point(551, 243);
            this.lnKBaidu.Name = "lnKBaidu";
            this.lnKBaidu.Size = new System.Drawing.Size(131, 12);
            this.lnKBaidu.TabIndex = 14;
            this.lnKBaidu.TabStop = true;
            this.lnKBaidu.Text = "百度（www.baidu.com）";
            this.lnKBaidu.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.lnKBaidu_LinkClicked);
            // 
            // butText
            // 
            this.butText.Location = new System.Drawing.Point(58, 183);
            this.butText.Name = "butText";
            this.butText.Size = new System.Drawing.Size(75, 23);
            this.butText.TabIndex = 15;
            this.butText.Text = "文本框";
            this.butText.UseVisualStyleBackColor = true;
            // 
            // emailRegister
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(688, 273);
            this.Controls.Add(this.butText);
            this.Controls.Add(this.lnKBaidu);
            this.Controls.Add(this.lalKey);
            this.Controls.Add(this.lblButton);
            this.Controls.Add(this.labMousePosition);
            this.Controls.Add(this.dgvShow);
            this.Controls.Add(this.but_show);
            this.Controls.Add(this.but_enter);
            this.Controls.Add(this.but_login);
            this.Controls.Add(this.textBox4);
            this.Controls.Add(this.text_name);
            this.Controls.Add(this.text_pwd);
            this.Controls.Add(this.text_account);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
            this.MaximizeBox = false;
            this.Name = "emailRegister";
            this.Text = "126邮箱注册";
            this.Load += new System.EventHandler(this.emailRegister_Load);
            this.KeyDown += new System.Windows.Forms.KeyEventHandler(this.emailRegister_KeyDown);
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.emailRegister_MouseDown);
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.emailRegister_MouseMove);
            ((System.ComponentModel.ISupportInitialize)(this.dgvShow)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox text_account;
        private System.Windows.Forms.TextBox text_pwd;
        private System.Windows.Forms.TextBox text_name;
        private System.Windows.Forms.TextBox textBox4;
        private System.Windows.Forms.Button but_login;
        private System.Windows.Forms.Button but_enter;
        private System.Windows.Forms.Button but_show;
        private System.Windows.Forms.DataGridView dgvShow;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column3;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column4;
        private System.Windows.Forms.Label labMousePosition;
        private System.Windows.Forms.Label lblButton;
        private System.Windows.Forms.Label lalKey;
        private System.Windows.Forms.LinkLabel lnKBaidu;
        private System.Windows.Forms.Button butText;
    }
}