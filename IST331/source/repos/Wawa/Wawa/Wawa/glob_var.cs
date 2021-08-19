using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace Wawa
{
    public static class glob_var
    {
        public static char newLine = '\n';
        static string _lstConfirmation;
        public static string lstConfirmation
        {
            get
            {
                return _lstConfirmation;
            }
            set
            {
                _lstConfirmation = value;
            }
        }
        static float _runningTotal;
        public static float runningTotal
        {
            get
            {
                return _runningTotal;
            }
            set
            {
                _runningTotal = value;
            }
        }
    }
}
