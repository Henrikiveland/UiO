R0 = R1 nor R2

ORR R0, R1, R2
MVN R0


LDR R0, G
LDR R1, H

CMP R0, R1
BGE FIRST
SUB R0,
BX LR

FIRST
ADD R0, R1
BX LR