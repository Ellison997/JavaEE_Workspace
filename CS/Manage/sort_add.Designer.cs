namespace Manage
{
    partial class sort_add
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
            this.text_name = new System.Windows.Forms.TextBox();
            this.text_describe = new System.Windows.Forms.TextBox();
            this.but_submit = new System.Windows.Forms.Button();
            this.but_cancel = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 26.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.Location = new System.Drawing.Point(58, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(159, 35);
            this.label1.TabIndex = 0;
            this.label1.Text = "添加工种";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(24, 65);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "工种名称";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(24, 108);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(53, 12);
            this.label3.TabIndex = 2;
            this.label3.Text = "工种描述";
            // 
            // text_name
            // 
            this.text_name.Location = new System.Drawing.Point(77, 62);
            this.text_name.Name = "text_name";
            this.text_name.Size = new System.Drawing.Size(167, 21);
            this.text_name.TabIndex = 3;
            // 
            // text_describe
            // 
            this.text_describe.Location = new System.Drawing.Point(77, 89);
            this.text_describe.Multiline = true;
            this.text_describe.Name = "text_describe";
            this.text_describe.Size = new System.Drawing.Size(167, 74);
            this.text_describe.TabIndex = 4;
            // 
            // but_submit
            // 
            this.but_submit.Location = new System.Drawing.Point(54, 190);
            this.but_submit.Name = "but_submit";
            this.but_submit.Size = new System.Drawing.Size(75, 23);
            this.but_submit.TabIndex = 5;
            this.but_submit.Text = "确定";
            this.but_submit.UseVisualStyleBackColor = true;
            this.but_submit.Click += new System.EventHandler(this.but_submit_Click);
            // 
            // but_cancel
            // 
            this.but_cancel.Location = new System.Drawing.Point(149, 190);
            this.but_cancel.Name = "but_cancel";
            this.but_cancel.Size = new System.Drawing.Size(75, 23);
            this.but_cancel.TabIndex = 6;
            this.but_cancel.Text = "取消";
            this.but_cancel.UseVisualStyleBackColor = true;
            this.but_cancel.Click += new System.EventHandler(this.but_cancel_Click);
            // 
            // sort_add
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.but_cancel);
            this.Controls.Add(this.but_submit);
            this.Controls.Add(this.text_describe);
            this.Controls.Add(this.text_name);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.MinimizeBox = false;
            this.Name = "sort_add";
            this.Text = "添加工种";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox text_name;
        private System.Windows.Forms.TextBox text_describe;
        private System.Windows.Forms.Button but_submit;
        private System.Windows.Forms.Button but_cancel;
    }
}