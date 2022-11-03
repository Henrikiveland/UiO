# Oppgave 3: Skop

def minFunksjon():
    for x in range(2):
        c = 2
        print(c)
        c += 1
        b = 10
        b += a
        print(b)
    return b


def hovedprogram():
    a = 42
    b = 0
    print(b)
    b = a
    a = minFunksjon()
    print(b)
    print(a)


hovedprogram()


# Først defineres funksjon "minFunksjon", som ikke skal ta imot noen parametere. Deretter defineres prosedyren
# "hovedprogram", som heller ikke tar noen parametere. Deretter kalles hovedprogram. Inne i hovedprogram opprettes en
# variabel "a" med verdi 42. Deretter oppretter vi en variabel "b" med verdi 0. Deretter printes variabelen "b" dvs.
# 0. Deretter settes variabelen "b" lik "a" dvs. 42. Deretter settes a lik funksjonen "minFunksjon". Deretter printes
# variabelen "b" dvs. 42. Deretter kalles "minFunksjon". I "minFunksjon" lages en forløkke «for x in range(2)» som
# vil kjøre 2 ganger. Først vil den lage en variabel "c" med verdi 2. deretter vil den printe variabelen "c" dvs. 2.
# Deretter endres "c" til å øke med 1 i verdi dvs. 4 Deretter lages en variabel "b" med verdi 10. Deretter endres "b"
# til å øke med "a". Variabelen a er ikke definert(den er bare definert inni prosedyren hovedprogram). Her vil det
# komme en feilmelding og programmet stopper.
