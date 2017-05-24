namespace Manage
{
    partial class ModifyJob
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
            this.label4 = new System.Windows.Forms.Label();
            this.txt_id = new System.Windows.Forms.TextBox();
            this.text_name = new System.Windows.Forms.TextBox();
            this.text_Remark = new System.Windows.Forms.TextBox();
            this.but_sub = new System.Windows.Forms.Button();
            this.but_exit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.Location = new System.Drawing.Point(127, 21);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(135, 20);
            this.label1.TabIndex = 0;
            this.label1.Text = "修改工种种类";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(23, 54);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "工作编号";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(208, 54);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(53, 12);
            this.label3.TabIndex = 2;
            this.label3.Text = "工种名称";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(23, 103);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(53, 12);
            this.label4.TabIndex = 3;
            this.label4.Text = "工种描述";
            // 
            // txt_id
            // 
            this.txt_id.Location = new System.Drawing.Point(82, 51);
            this.txt_id.Name = "txt_id";
            this.txt_id.Size = new System.Drawing.Size(120, 21);
            this.txt_id.TabIndex = 4;
            // 
            // text_name
            // 
            this.text_name.Location = new System.Drawing.Point(267, 51);
            this.text_name.Name = "text_name";
            this.text_name.Size = new System.Drawing.Size(115, 21);
            this.text_name.TabIndex = 5;
            // 
            // text_Remark
            // 
            this.text_Remark.Location = new System.Drawing.Point(82, 94);
            this.text_Remark.Multiline = true;
            this.text_Remark.Name = "text_Remark";
            this.text_Remark.Size = new System.Drawing.Size(245, 61);
            this.text_Remark.TabIndex = 6;
            // 
            // but_sub
            // 
            this.but_sub.Location = new System.Drawing.Point(82, 183);
            this.but_sub.Name = "but_sub";
            this.but_sub.Size = new System.Drawing.Size(75, 23);
            this.but_sub.TabIndex = 7;
            this.but_sub.Text = "确定";
            this.but_sub.UseVisualStyleBackColor = true;
            // 
            // but_exit
            // 
            this.but_exit.Location = new System.Drawing.Point(252, 183);
            this.but_exit.Name = "but_exit";
            this.but_exit.Size = new System.Drawing.Size(75, 23);
            this.but_exit.TabIndex = 8;
            this.but_exit.Text = "取消";
            this.but_exit.UseVisualStyleBackColor = true;
            // 
            // ModifyJob
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(406, 261);
            this.Controls.Add(this.but_exit);
            this.Controls.Add(this.but_sub);
            this.Controls.Add(this.text_Remark);
            this.Controls.Add(this.text_name);
            this.Controls.Add(this.txt_id);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "ModifyJob";
            this.Text = "修改工种种类";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txt_id;
        private System.Windows.Forms.TextBox text_name;
        private System.Windows.Forms.TextBox text_Remark;
        private System.Windows.Forms.Button but_sub;
        private System.Windows.Forms.Button but_exit;
    }
}