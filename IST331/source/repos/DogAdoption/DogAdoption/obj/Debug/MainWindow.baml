   M S B A M L   `   `   `  ����F  BDogAdoption, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null)clr-namespace:DogAdoptionDogAdoption  5   	       DogAdoption.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   +localclr-namespace:DogAdoption     5   	     � Title$  
MainWindow��5   	   $��700.692��6   $��1032.007��6-   .��5	      �  � ColumnDefinitions 5
   
   �� 5      $��0* �6   �� 5      .+�5   
   �� -   5         ��Name$ imgDogs��5      $
��Left=�6!   $	��670��6<   $	��Top=�6I   $
��1024��6a   $��dogs.jpg��6n   $��2��6�   $
��Fill=�6�    J� Opacity$
 0.42Q�6�   �� 5   
   -   5         ��Name$ 
lstDogName��5      $
��Left=�6&   $	��169��6A   $��
653,56,0,0q�6N   $	��Top=�6b   $	��136��6z   $��2��6�   .@�5      �� -   5         ��Name$ lstRiley��5      $��Riley��6,   $��16(�6<   6J   �� 5      -   5        $ lstClifford��5      $��Clifford��6/   $��16(�6B   6P   �� 5      -   5        $ 	lstScooby��5      $��
Scooby Doo��6-   $��16(�6B   6P   �� 5      -   5        $ lstBalto��5      $��Balto��6,   $��16(�6<   6J   5      �� 5   
   -   5         ��Name$ 
txtResults��5      $
��Left=�6&   $��79��6A   $��119,467,0,0q�6M    �� TextWrapping$
 Wrap=�6b   $	��Top=�6v   $	��789��6�    �� 
IsReadOnly . $��2��6�   �� 5   
   -   5        	 ��Name$	 lblChosenName��5      $�� ��6'   $
��Left=�62   $��	50,56,0,0q�6M   $	��Top=�6`   $��79��6x   $	��391��6�   $��36(�6�   $
��Bold"�6�   $��2��6�   �� 5   
   -	   5        $	 lblName��5      $��Choose a name:��6!   $
��Left=�6:   $��
494,56,0,0q�6U   $	��Top=�6i   $��54��6�   $	��159��6�   $��20(�6�   $��2��6�   �� 5   
   -
   5        
 ��Name$
 btnReset��5      $��Reset��6#   $
��Left=�63   $��466,569,0,0q�6N   $	��Top=�6c   $	��133��6{   $��78��6�   $��24(�6�   $��2��6�   �� 5   
   -   5        $ imgSelectedDog��5      $��2��6(   $
��Left=�6<   $	��322��6W   $��
88,140,0,0q�6d   $	��Top=�6x   $	��353��6�   $
��Fill=�6�   �� 5   
   -   5        $
 btnOrder��5      $��Order��6#   $
��Left=�63   $��653,569,0,0q�6N   $	��Top=�6c   $	��145��6{   $��78��6�   $��24(�6�   $��2��6�   6�   �� 5   
   -   5        $
 btnExit��5      $
��Exit��6"   $
��Left=�61   $��273,569,0,0q�6L   $	��Top=�6a   $	��133��6y   $��78��6�   $��24(�6�   $��2��6�   5      5      