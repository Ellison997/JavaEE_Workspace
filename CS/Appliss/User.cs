using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Appliss
{
    class User
    {
        int uid;

        public int Uid
        {
            get { return uid; }
            set { uid = value; }
        }

        String username;

        public String Username
        {
            get { return username; }
            set { username = value; }
        }
        String userpwd;

        public String Userpwd
        {
            get { return userpwd; }
            set { userpwd = value; }
        }
        String truename;

        public String Truename
        {
            get { return truename; }
            set { truename = value; }
        }

    }
}
