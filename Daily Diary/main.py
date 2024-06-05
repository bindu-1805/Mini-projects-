""" Import the necessary modules. We will use the datetime module to get the current date and time, the os module to create a directory 
and the tkinter module to create the user interface."""
import datetime
import os
import tkinter as tk

""" Define a function to create a directory to store our entries. 
We will use the os module to create a directory with the current date as the name."""
def create_directory():
    current_date = datetime.date.today()
    directory_name = current_date.strftime('%d-%m-%Y')
    if not os.path.exists(directory_name):
        os.mkdir(directory_name)

""" Define a function to save our diary entries. 
The function will open a file where you write the entry to the file and give it a filename."""
def save_entry():
    current_date_time = datetime.datetime.now()
    file_name = input("Enter the filename: ")
    entry = text_entry.get('1.0', 'end-1c')
    directory_name = current_date_time.strftime('%d-%m-%Y')
    file_path = os.path.join(directory_name, file_name + '.txt')
    with open(file_path, 'w') as file:
        file.write(entry)

""" Create the user interface using Tkinter. 
Create a main window with a text box for entering diary entries and two buttons for saving and quitting the application."""
root = tk.Tk()
root.title('Daily Diary')

text_entry = tk.Text(root, height=20, width=100)
text_entry.pack()

save_button = tk.Button(root, text='Save', command=save_entry)
save_button.pack()

close_button = tk.Button(root, text='Close', command=root.quit)
close_button.pack()

create_directory()

root.mainloop()

