   M S B A M L   `   `   `  ����L  HMovementAndTiming, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null5clr-namespace:MovementAndTimingMovementAndTiming  5   	   "    MovementAndTiming.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   1localclr-namespace:MovementAndTiming     5   	   -   5          �Name$  OnlyMain��5   	    � Title$ 
MainWindow��5   	   $	��350��6   $	��525��6)   .��5	      � -   5         �Name$ myGrid��5	      .+�5
   
   �� -   5         ��Name$ btnStep��5
      $
��Step��6"   $��Right=�61   $��304,238,80,40q�6M   $��Bottom=�6d   $��75��6   6�   �� 5   
   -   5        $ btnStartStop��5      $��Start��6'   $��Right=�67   $��214,238,160,40q�6S   $��Bottom=�6k   $��75��6�   6�   �� 5   
   -   5        $ btnExit��5      $
��Exit��6"   $��Right=�61   $��398,238,0,40q�6M   $��Bottom=�6c   $��75��6~   6�   �� 5   
   -   5         ��Name$ sliderDelay��5      $
��Left=�6&   $��304,177,0,0q�6A   $	��Top=�6V   $��25��6n   $	��191��6z    � Maximum$
 2000Q�6�    � SmallChange$	 200Q�6�    � LargeChange$	 200Q�6�    �� TickFrequency$	 200Q�6�   	 �� TickPlacement$	 BottomRight=�6�   
 � Value$

 1000Q�6�   6�   �� 5   
   -   5        $ sliderStepSize��5      $
��Left=�6)   $��304,113,0,0q�6D   $	��Top=�6Y   $��40��6q   $	��191��6}    � Minimum$ 10Q�6�   $ 50Q�6�   $ 10Q�6�   $ 10Q�6�   $ 10Q�6�   $	 BottomRight=�6�   $
 20Q�6�   6�   �� 5   
   -   5         ��Name$ lblStepSize��5      $��Step: 20��6%   $
��Left=�68   $��
214,99,0,0q�6S   $	��Top=�6g   $��85��6   �� 5   
   -	   5        $ lblTimeDelay��5      $��Delay: 1000��6&   $
��Left=�6<   $��214,159,0,0q�6W   $	��Top=�6l   �� 5   
   -
   5        $ btnThatMoves��5      $��0q�6'   $��Moving Button��6;   $
��Left=�6S   $��
224,40,0,0q�6n   $	��Top=�6�   $��90��6�   $��21��6�   5      5      