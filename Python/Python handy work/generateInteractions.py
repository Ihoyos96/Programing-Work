import random
from random import randint
import time

global cid;
global eid

def strTimeProp(start, end, format, prop):
    """Get a time at a proportion of a range of two formatted times.

    start and end should be strings specifying times formated in the
    given format (strftime-style), giving an interval [start, end].
    prop specifies how a proportion of the interval to be taken after
    start.  The returned time will be in the specified format.
    """

    stime = time.mktime(time.strptime(start, format))
    etime = time.mktime(time.strptime(end, format))

    ptime = stime + prop * (etime - stime)

    return time.strftime(format, time.localtime(ptime))


def randomDate(start, end, prop):
    return strTimeProp(start, end, '%m/%d/%Y %I:%M %p', prop)

def randomint14():
    return randint(1, 14)

def randomint11():
    return randint(1, 11)

def randDateprint():
    return randomDate("1/1/2012 1:30 PM", "12/7/2017 4:50 AM", random.random())

def randInteracton():
    rand = randint(1, 3)

    if (rand == 1):
        if (cid == 3 or cid == 6 or cid == 7 or cid == 8 or cid == 9):
            randtext = randint(0,1)
            if randtext == 0:
                return ("'Facebook', 'Phone', 'Great call, Alot of progress made!'")
            else:
                return ("'Facebook', 'Phone', 'We had a nice chat!'")
        if (cid == 4 or cid == 5 or cid == 13 or cid == 14):
            randtext = randint(0,1)
            if randtext == 0:
                return ("'Intel Corporation', 'Phone', 'Great call, Alot of progress made!'")
            else:
                return ("'Intel Corporation', 'Phone', 'We had a nice chat!'")
        if (cid == 1 or cid == 2 or cid == 10 or cid == 11 or cid == 12):
            randtext = randint(0,1)
            if randtext == 0:
                return ("'AT&T', 'Phone', 'Great call, Alot of progress made!'")
            else:
                return ("'AT&T', 'Phone', 'We had a nice chat!'")
    if (rand == 2):
        if (cid == 3 or cid == 6 or cid == 7 or cid == 8 or cid == 9):
            randtext = randint(0,1)
            if randtext == 0:
                return ("'Facebook', 'Email', 'Following up on our last conversation.'")
            else:
                return ("'Facebook', 'Email', 'We seem to be on the same page.'")
        if (cid == 4 or cid == 5 or cid == 13 or cid == 14):
            randtext = randint(0,1)
            if randtext == 0:
                return ("'Intel Corporation', 'Email', 'Following up on our last conversation.'")
            else:
                return ("'Intel Corporation', 'Email', 'We seem to be on the same page.'")
        if (cid == 1 or cid == 2 or cid == 10 or cid == 11 or cid == 12):
            randtext = randint(0,1)
            if randtext == 0:
                return ("'AT&T', 'Email', 'Following up on our last conversation.'")
            else:
                return ("'AT&T', 'Email', 'We seem to be on the same page.'")
    if (rand == 3):
        if (cid == 3 or cid == 6 or cid == 7 or cid == 8 or cid == 9):
            randtext = randint(0,1)
            if randtext == 0:
                return ("'Facebook', 'Postal', 'The documents I was waiting for have arrived'")
            else:
                return ("'Facebook', 'Postal', 'Old fashion correspondance, this guy knows how to business.'")
        if (cid == 4 or cid == 5 or cid == 13 or cid == 14):
            randtext = randint(0,1)
            if randtext == 0:
                return ("'Intel Corporation', 'Postal', 'The documents I was waiting for have arrived'")
            else:
                return ("'Intel Corporation', 'Postal', 'Old fashion correspondance, this guy knows how to business.'")
        if (cid == 1 or cid == 2 or cid == 10 or cid == 11 or cid == 12):
            randtext = randint(0,1)
            if randtext == 0:
                return ("'AT&T', 'Postal', 'The documents I was waiting for have arrived'")
            else:
                return ("'AT&T', 'Postal', 'Old fashion correspondance, this guy knows how to business.'")


for x in range(0, 20):
    eid = randomint11()
    cid = randomint14()
    print("('" + str(cid) + "', '" + str(eid) + "', '" + str(randDateprint()) + "', " + str(randInteracton()) + ")")
















##Sample Output
'''

('6', '1', '04-02-2014 00:00:00', 'Facebook', 'Email', 'We seem to be on the same page.'),
('5', '3', '08-06-2013 00:00:00', 'Intel Corporation', 'Email', 'Following up on our last conversation.'),
('10', '8', '03-15-2012 00:00:00', 'AT&T', 'Phone', 'We had a nice chat!'),
('6', '6', '07-04-2013 00:00:00', 'Facebook', 'Email', 'We seem to be on the same page.'),
('8', '11', '04-11-2017 00:00:00', 'Facebook', 'Postal', 'The documents I was waiting for have arrived'),
('14', '3', '07-06-2013 00:00:00', 'Intel Corporation', 'Postal', 'Old fashion correspondance, this guy knows how to business.'),
('3', '4', '04-17-2017 00:00:00', 'Facebook', 'Postal', 'The documents I was waiting for have arrived'),
('6', '1', '04-03-2016 00:00:00', 'Facebook', 'Phone', 'We had a nice chat!'),
('14', '1', '02-21-2013 00:00:00', 'Intel Corporation', 'Email', 'We seem to be on the same page.'),
('8', '6', '08-22/-2013 00:00:00', 'Facebook', 'Postal', 'The documents I was waiting for have arrived'),
('8', '7', '11-14-2013 00:00:00', 'Facebook', 'Email', 'We seem to be on the same page.'),
('4', '3', '05-09-2015 00:00:00', 'Intel Corporation', 'Email', 'We seem to be on the same page.'),
('4', '5', '01-05-2012 00:00:00', 'Intel Corporation', 'Phone', 'We had a nice chat!'),
('6', '4', '01-16-2015 00:00:00', 'Facebook', 'Postal', 'Old fashion correspondance, this guy knows how to business.'),
('9', '10', '09-02-2014 00:00:00', 'Facebook', 'Postal', 'Old fashion correspondance, this guy knows how to business.'),
('2', '10', '09-14-2014 00:00:00', 'AT&T', 'Phone', 'Great call, Alot of progress made!'),
('9', '3', '08-31-2014 00:00:00', 'Facebook', 'Phone', 'Great call, Alot of progress made!'),
('9', '1', '06-29-2014 00:00:00', 'Facebook', 'Postal', 'The documents I was waiting for have arrived'),
('9', '3', '04-24-2014 00:00:00', 'Facebook', 'Postal', 'Old fashion correspondance, this guy knows how to business.'),
('2', '5', '02-20-2016 00:00:00', 'AT&T', 'Email', 'We seem to be on the same page.');


'''
