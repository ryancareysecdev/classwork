﻿#pragma checksum "..\..\Drinks.xaml" "{8829d00f-11b8-4213-878b-770e8597ac16}" "DF732CF082EDE051DF67F65642D4728B8F0A0252A35D991AFB0FACCDD6B28D3D"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;
using Wawa;


namespace Wawa {
    
    
    /// <summary>
    /// Drinks
    /// </summary>
    public partial class Drinks : System.Windows.Window, System.Windows.Markup.IComponentConnector {
        
        
        #line 10 "..\..\Drinks.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button btnBottled;
        
        #line default
        #line hidden
        
        
        #line 13 "..\..\Drinks.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button btnCoffee;
        
        #line default
        #line hidden
        
        
        #line 16 "..\..\Drinks.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button btnFrozen;
        
        #line default
        #line hidden
        
        
        #line 19 "..\..\Drinks.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button btnReturntoMain;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/Wawa;component/drinks.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\Drinks.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.btnBottled = ((System.Windows.Controls.Button)(target));
            
            #line 10 "..\..\Drinks.xaml"
            this.btnBottled.Click += new System.Windows.RoutedEventHandler(this.BtnBottled_Click);
            
            #line default
            #line hidden
            return;
            case 2:
            this.btnCoffee = ((System.Windows.Controls.Button)(target));
            
            #line 13 "..\..\Drinks.xaml"
            this.btnCoffee.Click += new System.Windows.RoutedEventHandler(this.BtnCoffee_Click);
            
            #line default
            #line hidden
            return;
            case 3:
            this.btnFrozen = ((System.Windows.Controls.Button)(target));
            
            #line 16 "..\..\Drinks.xaml"
            this.btnFrozen.Click += new System.Windows.RoutedEventHandler(this.BtnFrozen_Click);
            
            #line default
            #line hidden
            return;
            case 4:
            this.btnReturntoMain = ((System.Windows.Controls.Button)(target));
            
            #line 19 "..\..\Drinks.xaml"
            this.btnReturntoMain.Click += new System.Windows.RoutedEventHandler(this.BtnReturntoMain_Click);
            
            #line default
            #line hidden
            return;
            }
            this._contentLoaded = true;
        }
    }
}
