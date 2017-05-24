namespace Appliss
{
    partial class Text
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
            this.labNum = new System.Windows.Forms.Label();
            this.textBoxs = new System.Windows.Forms.TextBox();
            this.but_ent = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // labNum
            // 
            this.labNum.AutoSize = true;
            this.labNum.Location = new System.Drawing.Point(32, 18);
            this.labNum.Name = "labNum";
            this.labNum.Size = new System.Drawing.Size(0, 12);
            this.labNum.TabIndex = 0;
            // 
            // textBoxs
            // 
            this.textBoxs.Location = new System.Drawing.Point(34, 41);
            this.textBoxs.Multiline = true;
            this.textBoxs.Name = "textBoxs";
            this.textBoxs.Size = new System.Drawing.Size(202, 89);
            this.textBoxs.TabIndex = 1;
            // 
            // but_ent
            // 
            this.but_ent.Location = new System.Drawing.Point(34, 150);
            this.but_ent.Name = "but_ent";
            this.but_ent.Size = new System.Drawing.Size(75, 23);
            this.but_ent.TabIndex = 2;
            this.but_ent.Text = "确定";
            this.but_ent.UseVisualStyleBackColor = true;
            // 
            // Text
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 196);
            this.Controls.Add(this.but_ent);
            this.Controls.Add(this.textBoxs);
            this.Controls.Add(this.labNum);
            this.Name = "Text";
            this.Text = "TextBox";
            this.Load += new System.EventHandler(this.Text_Load);
            this.TextChanged += new System.EventHandler(this.Text_TextChanged);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labNum;
        private System.Windows.Forms.TextBox textBoxs;
        private System.Windows.Forms.Button but_ent;
    }
}