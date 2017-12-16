import random

user_selection = eval(input('Rock [0], Paper [1], Scissors [2], choose one by inputing theselection number: '))

if user_selection == 0:
    user_selection = 'Rock'

if user_selection == 1:
    user_selection = 'Paper'

if user_selection == 2:
    user_selection = 'Scissors'

computer_selection = random.randint(0,2)

if computer_selection == 0:
    computer_selection = 'Rock'

if computer_selection == 1:
    computer_selection = 'Paper'

if computer_selection == 2:
    computer_selection = 'Scissors'


print('After a long and exhausting battle it is finally over! ', end='')
print('The fight has resulted in', end=' ')		



#Rock outcomes
if user_selection == 'Rock' and computer_selection == 'Rock':
    print('a TIE!')
    
if user_selection == 'Scissors' and computer_selection == 'Rock':
    print('a crushing DEFEAT for your hero! YOU LOSE!')
		
if user_selection == "Paper" and computer_selection == 'Rock':
    print('a Victory for you hero! YOU WIN!')

#Paper outcomes
if user_selection == 'Rock' and computer_selection == "Paper":
    print('a crushing DEFEAT for your hero! YOU LOSE!')
	
if user_selection == 'Scissors' and computer_selection == 'Paper':
    print('a VICTORY for your hero! YOU WIN!')
	
if user_selection == 'Paper' and computer_selection == 'Paper':
    print('a TIE!')
	

#Scissor outcomes
if user_selection == 'Rock' and computer_selection == 'Scissors':
    print('a VICTORY for your hero! YOU WIN!')

if user_selection == 'Scissors' and computer_selection == 'Scissors':
    print('a TIE!')

if user_selection == 'Paper' and computer_selection == 'Scissors':
    print('a crushing DEFEAT for your hero! YOU LOSE!')

