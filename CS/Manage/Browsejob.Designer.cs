namespace Manage
{
    partial class Browsejob
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
            this.dataGrid = new System.Windows.Forms.DataGridView();
            this.but_updata = new System.Windows.Forms.Button();
            this.but_delete = new System.Windows.Forms.Button();
            this.but_exit = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGrid)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGrid
            // 
            this.dataGrid.AllowUserToOrderColumns = true;
            this.dataGrid.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dataGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGrid.Location = new System.Drawing.Point(0, 0);
            this.dataGrid.Name = "dataGrid";
            this.dataGrid.RowHeadersVisible = false;
            this.dataGrid.RowTemplate.Height = 23;
            this.dataGrid.Size = new System.Drawing.Size(409, 214);
            this.dataGrid.TabIndex = 0;
            this.dataGrid.CurrentCellChanged += new System.EventHandler(this.dataGrid_CurrentCellChanged);
            // 
            // but_updata
            // 
            this.but_updata.Location = new System.Drawing.Point(90, 226);
            this.but_updata.Name = "but_updata";
            this.but_updata.Size = new System.Drawing.Size(75, 23);
            this.but_updata.TabIndex = 1;
            this.but_updata.Text = "修改";
            this.but_updata.UseVisualStyleBackColor = true;
            this.but_updata.Click += new System.EventHandler(this.but_updata_Click);
            // 
            // but_delete
            // 
            this.but_delete.Location = new System.Drawing.Point(171, 226);
            this.but_delete.Name = "but_delete";
            this.but_delete.Size = new System.Drawing.Size(75, 23);
            this.but_delete.TabIndex = 2;
            this.but_delete.Text = "删除";
            this.but_delete.UseVisualStyleBackColor = true;
            // 
            // but_exit
            // 
            this.but_exit.Location = new System.Drawing.Point(300, 226);
            this.but_exit.Name = "but_exit";
            this.but_exit.Size = new System.Drawing.Size(75, 23);
            this.but_exit.TabIndex = 3;
            this.but_exit.Text = "退出";
            this.but_exit.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 236);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(0, 12);
            this.label1.TabIndex = 4;
            // 
            // Browsejob
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(408, 261);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.but_exit);
            this.Controls.Add(this.but_delete);
            this.Controls.Add(this.but_updata);
            this.Controls.Add(this.dataGrid);
            this.Name = "Browsejob";
            this.Text = "工种种类浏览";
            this.Load += new System.EventHandler(this.Browsejob_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGrid)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGrid;
        private System.Windows.Forms.Button but_updata;
        private System.Windows.Forms.Button but_delete;
        private System.Windows.Forms.Button but_exit;
        private System.Windows.Forms.Label label1;

    }
}