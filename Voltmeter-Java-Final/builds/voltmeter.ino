//Arduino - Java Voltmeter
//Program needs Java Voltmeter desktop applictaion
//Created by Felix Holz on 14.11.2017

#define A0 PIN_POTI

int adcvalue = 0;

void setup()
{
	Serial.begin(9600);
}

void loop()
{
	if(Serial.available() > 0)
	{
		char in = Serial.read();
		if(in == 'R')
		{
			adcvalue = analogRead(PIN_POTI);
			Serial.println(adcvalue);
		}
	}
}