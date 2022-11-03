from sang import Sang
from spilleliste import Spilleliste


def hovedprogram1():
    sang1 = Sang("Imagine Dragons and Kygo", "Born To Be Yours")
    print(sang1.spill())
    print(sang1.sjekkArtist("Kyg"))
    print(sang1)

def hovedprogram2():
    allMusikk = Spilleliste('Hele musikkbiblioteket')
    allMusikk.lesFraFil('musikk.txt')


hovedprogram2()