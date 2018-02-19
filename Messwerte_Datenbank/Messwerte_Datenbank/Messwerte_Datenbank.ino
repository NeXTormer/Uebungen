
void setup()
{
	Serial.begin(9600);
}

void loop()
{
	int poti = analogRead(A0);
	int ldr = analogRead(A1);
	String werner = (poti + ";" + ldr);
	Serial.write(poti);
	delay(1000);
}

