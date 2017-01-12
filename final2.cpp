#include <windows.h>
#include <iostream>
#include <vector>
#include <math.h>
#include <fstream>
#include <cstdlib>
#include <string>
#include <map>
#include <sstream>
#include <conio.h>
#include <exception>
#include <iomanip>
#include <memory>
#include <algorithm>
using namespace std;


vector<string> key;
vector<double> value;
map<string, double> ip;
map<string, string> dtl;

int day = 1;
int month = 1;
int year = 2015;

double valueExtractor(string s){
	return atof(s.c_str());
}

void writestaticData1(fstream& file2){
    file2<<"\nSimulated Treatment Pressure		Time	Pressure (PSI)7:38	2500\r8:29	2150\r10:09	2000\r10:14	1300\r10:26	1100\r10:29	567\r10:39	500\r10:48	400\r10:49	400\r11:14	400\r11:25	400\r11:40	400\n\n/\n\n";
}

void writestaticData2(fstream& file2){
    file2<<"Proposed Stimulation Design\n\nNO. 	STAGE NAME   VOL(BBLs) CONC.(%)  VIS(CP)  RATE(BPM) PRES (PSI)\r1	Pre-Flush	3600	  5	     1.5	3	2500\r2	MAIN-ACID	2210	  28	     1.8	4	2150\r3	VCA-DIVERTER	857	  0	      25	4	2000\r4	MAIN-ACID	2110	  28	     1.8	4	1300\r5	VCA-DIVERTER	857	  0	      25	5	1100\r6	MAIN-ACID	2110	  28	     1.8	10	567\r7	VCA-DIVERTER	857	  0	      25	10	500\r8	MAIN-ACID	2110	  28	     1.8	10	400\r9	VCA-DIVERTER	857	  0	      25	10	400\r10	MAIN-ACID	2135	  15	     1.6	10	400\r11	VCA-DIVERTER	857	  0	      25	13	400\r12	OVER-FLUSH	4662	  0	     1.6	15	400\n\n/\n\n";
    file2<<"Sensitivity Based on Viscosity  (% Volume)				          Case I   Case II	Case III\rDepth (FT)	% Volume 	% Volume 	% Volume 10000-10100	0.10 %	0.10 %	0.10 %\r10100-10110	1.10 %	1.10 %	1.10 %\r10110-10130	1.10 %	1.10 %	1.10 %\r10130-10135	3.00 %	3.00 %	3.00 %\r10135-10150	2.00 %	2.00 %	2.00 %\r10150-10157	5.00 %	5.00 %	5.00 %\r10157-10170	1.00 %	1.00 %	1.00 %\r10170-10178	5.50 %	5.50 %	5.50 %\r10178-10185	2.10 %	2.10 %	2.10 %\r10200-10210	2.50 %	2.50 %	2.50 %\n\n/\n\n";
    file2<<"Sensitivity Based on Viscosity (Penetration Length)				Case I	Case II	Case III\rDepth (FT)	Penetration Length (FT)	Penetration Length (FT)	Penetration Length (FT)\r10000-10100	0.1	0.1	0.1\r10100-10110	1.1	1.1	1.1\r10110-10130	1.1	1.1	1.1\r10130-10135	3	3	3\r10135-10150	2	2	2\r10150-10157	5	5	5\r10157-10170	1	1	1\r10170-10178	5.5	5.5	5.5\r10178-10185	2.1	2.1	2.1\r10200-10210	2.5	2.5	2.5\r10210-10220	3	3	3\r10220-10225	3	3	3\r10225-10235	4.5	4.5	4.5\r10235-10242	3	3	3\r10242-10248	4	4	4\r10248-10260	6	6	6\r10260-10267	2.5	2.5	2.5\r10267-10275	7	7	7\r10300-10310	8.3	8.3	8.3\r10310-10320	8	8	8\r10320-10330	7	7	7\r10330-10335	6	6	6\r10335-10340	5.3	5.3	5.3\r10340-10345	5	5	5\r10345-10370	4	4	4\n\n/\n\n";
    file2<<"Sensitivity Based on Viscosity (Skin)				Case I	Case II	Case III\rDepth (FT)	Skin	Skin	Skin\r10000-10100	-0.1	-0.1	-0.1\r10100-10110	-1.1	-1.1	-1.1\r10110-10130	-1.1	-1.1	-1.1\r10130-10135	-3	-3	-3\r10135-10150	-2	-2	-2\r10150-10157	-5	-5	-5\r10157-10170	-1	-1	-1\r10170-10178	-5.5	-5.5	-5.5\r10178-10185	-2.1	-2.1	-2.1\r10200-10210	-2.5	-2.5	-2.5\r10210-10220	-3	-3	-3\r10220-10225	-3	-3	-3\r10225-10235	-4.5	-4.5	-4.5\r10235-10242	-3	-3	-3\r10242-10248	-4	-4	-4\r10248-10260	-6	-6	-6\r10260-10267	-2.5	-2.5	-2.5\r10267-10275	-7	-7	-7\r10300-10310	-8.3	-8.3	-8.3\r10310-10320	-8	-8	-8\r10320-10330	-7	-7	-7\r10330-10335	-6	-6	-6\r10335-10340	-5.3	-5.3	-5.3\r10340-10345	-5	-5	-5\r10345-10370	-4	-4	-4			\n\n/\n\n";
    file2<<"Sensitivity Based on Viscosity (Production)				Case I	Case II	Case III\rDate	Production (Bbls/d)	Production (Bbls/d)	Production (Bbls/d)\r01/01/15	500	500	500\r11/01/15	510	510	510\r21/01/15	520	520	520\r31/01/15	530	530	530\r10/02/15	540	540	540\r20/02/15	550	550	550\r02/03/15	560	560	560\r12/03/15	570	570	570\r22/03/15	580	580	580\r01/04/15	590	590	590\r11/04/15	600	600	600\r21/04/15	595	595	595\r01/05/15	590	590	590\r11/05/15	585	585	585\r21/05/15	580	580	580\r31/05/15	575	575	575\r10/06/15	570	570	570\r20/06/15	565	565	565\r30/06/15	560	560	560\r10/07/15	555	555	555\r20/07/15	550	550	550\r30/07/15	545	545	545\r09/08/15	540	540	540\r19/08/15	535	535	535\r29/08/15	530	530	530\r08/09/15	525	525	525\r18/09/15	520	520	520\r28/09/15	515	515	515\r08/10/15	510	510	510\r18/10/15	505	505	505\r28/10/15	500	500	500\r07/11/15	495	495	495\r17/11/15	490	490	490\r27/11/15	485	485	485\r07/12/15	480	480	480\r17/12/15	475	475	475\r27/12/15	470	470	470\r06/01/16	465	465	465\r16/01/16	460	460	460\r26/01/16	455	455	455\r05/02/16	450	450	450\r15/02/16	445	445	445\r25/02/16	440	440	440\r06/03/16	435	435	435\r16/03/16	430	430	430\r26/03/16	425	425	425\r05/04/16	420	420	420\r15/04/16	415	415	415\r25/04/16	410	410	410\r05/05/16	405	405	405\r15/05/16	400	400	400\r25/05/16	395	395	395\r04/06/16	390	390	390\r14/06/16	385	385	385\r24/06/16	380	380	380\r04/07/16	375	375	375\r14/07/16	370	370	370\r24/07/16	365	365	365\r03/08/16	360	360	360\r13/08/16	355	355	355\r23/08/16	350	350	350\r02/09/16	345	345	345\r24/09/16	340	340	340\r22/09/16	335	335	335\r02/10/16	330	330	330\r12/10/16	325	325	325\r22/10/16	320	320	320\r01/11/16	315	315	315\r11/11/16	310	310	310\r21/11/16	305	305	305\r01/12/16	300	300	300\r11/12/16	295	295	295\r21/12/16	290	290	290\r31/12/16	285	285	285\n\n/\n\n";
    file2<<"Sensitivity Based on Pump Rate  (% Volume)				Case I	Case II	Case III\rDepth (FT)	% Volume 	% Volume 	% Volume 10000-10100	0.10 %	0.10 %	0.10 %\r10100-10110	1.10 %	1.10 %	1.10 %\r10110-10130	1.10 %	1.10 %	1.10 %\r10130-10135	3.00 %	3.00 %	3.00 %\r10135-10150	2.00 %	2.00 %	2.00 %\r10150-10157	5.00 %	5.00 %	5.00 %\r10157-10170	1.00 %	1.00 %	1.00 %\r10170-10178	5.50 %	5.50 %	5.50 %\r10178-10185	2.10 %	2.10 %	2.10 %\n\n/\n\n";
    file2<<"Sensitivity Based on Pump Rate  (Penetration Length)				Case I	Case II	Case III\rDepth (FT)	Penetration Length (FT)	Penetration Length (FT)	Penetration Length (FT)\r10000-10100	0.1	0.1	0.1\r10100-10110	1.1	1.1	1.1\r10110-10130	1.1	1.1	1.1\r10130-10135	3	3	3\r10135-10150	2	2	2\r10150-10157	5	5	5\r10157-10170	1	1	1\r10170-10178	5.5	5.5	5.5\r10178-10185	2.1	2.1	2.1\r10200-10210	2.5	2.5	2.5\r10210-10220	3	3	3\r10220-10225	3	3	3\r10225-10235	4.5	4.5	4.5\r10235-10242	3	3	3\r10242-10248	4	4	4\r10248-10260	6	6	6\r10260-10267	2.5	2.5	2.5\r10267-10275	7	7	7\r10300-10310	8.3	8.3	8.3\r10310-10320	8	8	8\r10320-10330	7	7	7\r10330-10335	6	6	6\r10335-10340	5.3	5.3	5.3\r10340-10345	5	5	5\r10345-10370	4	4	4\n\n/\n\n";
    file2<<"Sensitivity Based on Pump Rate  (Skin)				Case I	Case II	Case III\rDepth (FT)	Skin	Skin	Skin10000-10100	-0.1	-0.1	-0.1\r10100-10110	-1.1	-1.1	-1.1\r10110-10130	-1.1	-1.1	-1.1\r10130-10135	-3	-3	-3\r10135-10150	-2	-2	-2\r10150-10157	-5	-5	-5\r10157-10170	-1	-1	-1\r10170-10178	-5.5	-5.5	-5.5\r10178-10185	-2.1	-2.1	-2.1\r10200-10210	-2.5	-2.5	-2.5\r10210-10220	-3	-3	-3\r10220-10225	-3	-3	-3\r10225-10235	-4.5	-4.5	-4.5\r10235-10242	-3	-3	-3\r10242-10248	-4	-4	-4\r10248-10260	-6	-6	-6\r10260-10267	-2.5	-2.5	-2.5\r10267-10275	-7	-7	-7\r10300-10310	-8.3	-8.3	-8.3\r10310-10320	-8	-8	-8\r10320-10330	-7	-7	-7\r10330-10335	-6	-6	-6\r10335-10340	-5.3	-5.3	-5.3\r10340-10345	-5	-5	-5\r10345-10370	-4	-4	-4\n\n/\n\n";
    file2<<"Sensitivity Based on Pump Rate  (Production)				Case I	Case II	Case III\rDate	Production (Bbls/d)	Production (Bbls/d)	Production (Bbls/d)\r01/01/15	500	500	500\r11/01/15	510	510	510\r21/01/15	520	520	520\r31/01/15	530	530	530\r10/02/15	540	540	540\r20/02/15	550	550	550\r02/03/15	560	560	560\r12/03/15	570	570	570\r22/03/15	580	580	580\r01/04/15	590	590	590\r11/04/15	600	600	600\r21/04/15	595	595	595\r01/05/15	590	590	590\r11/05/15	585	585	585\r21/05/15	580	580	580\r31/05/15	575	575	575\r10/06/15	570	570	570\r20/06/15	565	565	565\r30/06/15	560	560	560\r10/07/15	555	555	555\r20/07/15	550	550	550\r30/07/15	545	545	545\r09/08/15	540	540	540\r19/08/15	535	535	535\r29/08/15	530	530	530\r08/09/15	525	525	525\r18/09/15	520	520	520\r28/09/15	515	515	515\r08/10/15	510	510	510\r18/10/15	505	505	505\n\n/\n\n";
    file2<<"Sensitivity Based on Acid Concentration  (% Volume)				Case I	Case II	Case III\rDepth (FT)	% Volume 	% Volume 	% Volume 10000-10100	0.10 %	0.10 %	0.10 %\r10100-10110	1.10 %	1.10 %	1.10 %\r10110-10130	1.10 %	1.10 %	1.10 %\r10130-10135	3.00 %	3.00 %	3.00 %\r10135-10150	2.00 %	2.00 %	2.00 %\r10150-10157	5.00 %	5.00 %	5.00 %\r10157-10170	1.00 %	1.00 %	1.00 %\r10170-10178	5.50 %	5.50 %	5.50 %\n\n/\n\n";
    file2<<"Sensitivity Based on Acid Concentration (Penetration Length)				Case I	Case II	Case III\rDepth (FT)	Penetration Length (FT)	Penetration Length (FT)	Penetration Length (FT)\r10000-10100	0.1	0.1	0.1\r10100-10110	1.1	1.1	1.1\r10110-10130	1.1	1.1	1.1\r10130-10135	3	3	3\r10135-10150	2	2	2\r10150-10157	5	5	5\r10157-10170	1	1	1\r10170-10178	5.5	5.5	5.5\r10178-10185	2.1	2.1	2.1\n\n/\n\n";
    file2<<"Sensitivity Based on Acid Concentration (Skin)				Case I	Case II	Case III\rDepth (FT)	Skin	Skin	Skin\r10000-10100	-0.1	-0.1	-0.1\r10100-10110	-1.1	-1.1	-1.1\r10110-10130	-1.1	-1.1	-1.1\r10130-10135	-3	-3	-3\r10135-10150	-2	-2	-2\r10150-10157	-5	-5	-5\n\n/\n\n";
    file2<<"Sensitivity Based on Acid Concentration (Production)				Case I	Case II	Case III\rDate	Production (Bbls/d)	Production (Bbls/d)	Production (Bbls/d)\r01/01/15	500	500	500\r11/01/15	510	510	510\r21/01/15	520	520	520\r31/01/15	530	530	530\r10/02/15	540	540	540\r20/02/15	550	550	550\r02/03/15	560	560	560\r12/03/15	570	570	570\r22/03/15	580	580	580\r01/04/15	590	590	590\n\n/\n\n";
    file2<<"Sensitivity Based on Acid Volume  (% Volume)				Case I	Case II	Case III\rDepth (FT)	% Volume 	% Volume 	% Volume 10000-10100	0.10 %	0.10 %	0.10 %\r10100-10110	1.10 %	1.10 %	1.10 %\r10110-10130	1.10 %	1.10 %	1.10 %\r10130-10135	3.00 %	3.00 %	3.00 %\r10135-10150	2.00 %	2.00 %	2.00 %\r10150-10157	5.00 %	5.00 %	5.00 %\n\n/\n\n";
    file2<<"Sensitivity Based on Acid Volume (Penetration Length)				Case I	Case II	Case III\rDepth (FT)	Penetration Length (FT)	Penetration Length (FT)	Penetration Length (FT)\r10000-10100	0.1	0.1	0.1\r10100-10110	1.1	1.1	1.1\r10110-10130	1.1	1.1	1.1\r10130-10135	3	3	3\r10135-10150	2	2	2\r10150-10157	5	5	5\r10157-10170	1	1	1\r10170-10178	5.5	5.5	5.5\r10178-10185	2.1	2.1	2.1\n\n/\n\n";
    file2<<"Sensitivity Based on Acid Volume (Skin)				Case I	Case II	Case III\rDepth (FT)	Skin	Skin	Skin\r10000-10100	-0.1	-0.1	-0.1\r10100-10110	-1.1	-1.1	-1.1\r10110-10130	-1.1	-1.1	-1.1\r10130-10135	-3	-3	-3\r10135-10150	-2	-2	-2\r10150-10157	-5	-5	-5\r10157-10170	-1	-1	-1\r10170-10178	-5.5	-5.5	-5.5\r10178-10185	-2.1	-2.1	-2.1\r10200-10210	-2.5	-2.5	-2.5\r10210-10220	-3	-3	-3\n\n/\n\n";
    file2<<"Sensitivity Based on Viscosity (Production)				Case I	Case II	Case III\rDate	Production (Bbls/d)	Production (Bbls/d)	Production (Bbls/d)\r01/01/15	500	500	500\r11/01/15	510	510	510\r21/01/15	520	520	520\r31/01/15	530	530	530\r10/02/15	540	540	540\r20/02/15	550	550	550\r02/03/15	560	560	560\r12/03/15	570	570	570\r22/03/15	580	580	580\r01/04/15	590	590	590\r11/04/15	600	600	600\n\n/\n\n";
    file2<<"Sensitivity Based on Shear Thinning Diverter  (% Volume)				Case I	Case II	Case III\rDepth (FT)	% Volume 	% Volume 	% Volume 10000-10100	0.10 %	0.10 %	0.10 %\r10100-10110	1.10 %	1.10 %	1.10 %\r10110-10130	1.10 %	1.10 %	1.10 %\r10130-10135	3.00 %	3.00 %	3.00 %\r10135-10150	2.00 %	2.00 %	2.00 %\r10150-10157	5.00 %	5.00 %	5.00 %\n\n/\n\n";
    file2<<"Sensitivity Based on Shear Thinning Diverter (Penetration Length)				Case I	Case II	Case III\rDepth (FT)	Penetration Length (FT)	Penetration Length (FT)	Penetration Length (FT)\r10000-10100	0.1	0.1	0.1\r10100-10110	1.1	1.1	1.1\r10110-10130	1.1	1.1	1.1\r10130-10135	3	3	3\r10135-10150	2	2	2\r10150-10157	5	5	5\r10157-10170	1	1	1\r10170-10178	5.5	5.5	5.5\r10178-10185	2.1	2.1	2.1\r10200-10210	2.5	2.5	2.5\r10210-10220	3	3	3\r10220-10225	3	3	3\n\n/\n\n";
    file2<<"Sensitivity Based on Shear Thinning Diverter(Skin)				Case I	Case II	Case III\rDepth (FT)	Skin	Skin	Skin\r10000-10100	-0.1	-0.1	-0.1\r10100-10110	-1.1	-1.1	-1.1\r10110-10130	-1.1	-1.1	-1.1\r10130-10135	-3	-3	-3\r10135-10150	-2	-2	-2\r10150-10157	-5	-5	-5\r10157-10170	-1	-1	-1\r10170-10178	-5.5	-5.5	-5.5\r10178-10185	-2.1	-2.1	-2.1\r10200-10210	-2.5	-2.5	-2.5\r10210-10220	-3	-3	-3\r10220-10225	-3	-3	-3\n\n/\n\n";
    file2<<"Sensitivity Based on Shear Thinning Diverter (Production)				Case I	Case II	Case III\rDate	Production (Bbls/d)	Production (Bbls/d)	Production (Bbls/d)\r01/01/15	500	500	500\r11/01/15	510	510	510\r21/01/15	520	520	520\r31/01/15	530	530	530\r10/02/15	540	540	540\r20/02/15	550	550	550\r02/03/15	560	560	560\r12/03/15	570	570	570\r22/03/15	580	580	580\r01/04/15	590	590	590\r11/04/15	600	600	600\r21/04/15	595	595	595\r01/05/15	590	590	590\r11/05/15	585	585	585\n\n/\n\n";
    file2<<"Calibrated Wormhole	Vi(M/s)	PVTBT\r2.41	0.2055\r2.61	0.2555\r2.81	0.3055\r3.01	0.3555\r3.21	0.4055\r3.41	0.4555\r3.61	0.5055\r3.81	0.5555\r4.01	0.6055\r4.21	0.6555/	2.41	0.2055\r2.61	0.2555\r2.81	0.3055\r3.01	0.3555\r3.21	0.4055\r3.41	0.4555\r3.61	0.5055\r3.81	0.5555\r4.01	0.6055\r4.21	0.6555\n\n/\n\n";
    file2<<"END";
}

string doubleToString(double x){
    std::ostringstream os;
    os<<x;
    string sf = os.str();
    return sf;
}

void getInput(){

    string file_location = "";
	string file = "Input\\Chemplace_Input_Data.txt";
	string abs_loc = file_location+file;
	fstream file1;
	file1.open(abs_loc.c_str(),ios::in);
	if(!file1) cout<<"null"<<endl;
    string s;
    while(getline(file1, s))
	{
		string x="",y="";
		int i=0;
		if(s[1]=='*'||s[1]=='/')
			continue;
		while(s[i]!='=')
		{
            x += s[i];
            i++;
		}
		i++;
        for(;i<s.size();i++)
        {
        	y += s[i];
        }

       if(y[0]<='9'&&y[0]>='0'){
            double z = (valueExtractor(y));
            key.push_back(x);
            value.push_back(z);
            ip[x] = z;
        }
       else{
           dtl[x] = y;
       }

	}
}

void changeDate(int days){
    day = day+days;

   // cout<<month<<"-"<<endl;

    if(month==2){
       // cout<<"hello"<<endl;
            if(year%4==0)
            {
                if(day>29)
                {
                    month++;
                    day = day - 29;
                }
            }
            else{
                if(day>28)
                {
                    month++;
                    day = day - 28;
                }
            }
    }

    if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
        if(day>31)
        {
            month++;
            day = day - 31;
        }}
    else if(month==4||month==6||month==9||month==11){
        if(day>30)
        {
            month++;
            day = day - 30;
        }
    }

    if(month>12)
        month = 1;
}

int main()
{
    float Q1,Qo1;
double C[200][10][10],X[100][100],P[100][100],DepthF[100],DepthT[100],B[100][100],Vwo,s[100][10],prodl[100],J[100][100],ZP[100],InjP[100],PV[100][100],K[100][100];
    float pi=3.14,Cos,Coq,Kq=.0026,Ks=.5294,Cirs,Cirq;
    float Sigmas=22.44,wee,wee1,wee2;
    int Sigmaq=6;
    double Qo,Q,Qinj;
    float Ccli;
    float Cfi;
    int Rd=2,h=10;
    float t=0.5,sum1=0;
    float po;
    float kd;
    float kud[100];
    int lab;
    float mu;
    float r;
    int j=1,k,l;
    int i;
    float R,D;
    float x,rd;
    float tem,tem1;
    getInput();
    fstream file2;
	file2.open("Output\\ChemPlace_Output_File_Data.txt",ios::out);

    vector<string> AcidPlacement;
    vector<string> PostStimulationSkin;
    vector<string> AcidPenetration;
    vector<string> PostStimulationProduction;



    D = ip["WellDiaInch"];
    //cout<<D<<endl;
    r=D/2;
    float rwc=r*2.54;
    //rd = damaged radius
    rd = 14;
    float z=((rd-r)/5);
    int a;

    R=700;
    float re=R*2.54;
    int n,m,Ci=1;


    //cout<<"\n"<<"input the volume percentage of the calcite in the reservoir";
    //cin>>x;
    x=.1;
    //cout<<"\n"<<"enter the silicate conc.:";
    //cin>>Cos;
    Cos=.00142;
    Cirs=0.2*Cos;

    //cout<<"\n"<<"enter the quartz conc.:";
    //cin>>Coq;
    Coq=.0327;
    Cirq=0.2*Coq;

    lab=3;

    //cout<<"\n"<<"enter the initial Hcl acid conc.:";
    //cin>>Ccli;
    Ccli=.00353;

    l = ip["NoofLayers"];
    //cout<<l<<endl;

    a = ip["NOofStages"];
    //cout<<a<<endl;

    float Sum=0.0,skin[100];

    int iter;
    for(iter=1;iter<=l;iter++)
    {
        string Key = "TVDFT";
        string Key2 = doubleToString(iter-1);
        Key = Key + Key2;
        P[iter][1] = ip[Key];
        //cout<<"P(1): "<<iter<<": "<<P[iter][1]<<endl;
        string KeyDepthF = "FormDefthFT"+Key2;
        string KeyDepthT = "ToDefthFT"+Key2;
        DepthF[iter] = ip[KeyDepthF];
        DepthT[iter] = ip[KeyDepthT];

        //cout<<DepthF[iter]<<"-"<<DepthT[iter]<<endl;
        //cout<<P[iter][1]<<endl;;
        string Key3 = "PermMD"+Key2;
        kud[iter] = ip[Key3];
        //cout<<kud[iter]<<endl;
        string Key4 = "PreStimSkin"+Key2;
        skin[iter] = ip[Key4];
        //cout<<skin[iter]<<endl;

        P[iter][2]=kud[iter]/((skin[iter]/log((rd)/r))+1);
        //cout<<"P(2): "<<iter<<": "<<P[iter][2]<<endl;
        Sum=Sum+(P[iter][1]*P[iter][2]);
    }

   //cout<<Sum<<endl;

   double Production = 0.0;

   int y;
   for(y=1;y<=l;y++)
   {
        int b;
        for(b=1;b<=a;b++)
       {
     //  cout<<"\n"<<X[2][1];
       string Key = "StavageVolBbls"+doubleToString(b-1);
       Qinj = ip[Key];
       //cout<<Qinj<<endl;

       string KeyZP = "ZonePressPSI"+doubleToString(y-1);
       ZP[y] = ip[KeyZP];
       //cout<<"Zone Pressure: "<<ZP[y]<<endl;

       string KeyIP = "InjPressPSI"+doubleToString(b-1);
       InjP[b] = ip[KeyIP];
       //cout<<"Injection Pressure: "<<InjP[b]<<endl;

       string Key2 = "PumpRateBMP"+doubleToString(b-1);
       Qo = ip[Key2];
       //cout<<Qo<<endl;
       string Keyf = "Conc"+doubleToString(b-1);
       Cfi = ip[Keyf];
       //cout<<Cfi<<endl;

       string Keym = "Vise"+doubleToString(b-1);
       mu = ip[Keym];
       //cout<<mu<<endl;

       string Key3 = "Poro"+doubleToString(y-1);
            po = ip[Key3];

            Q=Qo*((P[y][j]*P[y][j+1])/Sum);
         //   cout<<"\n"<<"Q::"<<Q;
            PV[y][1]=((Q/Qo)*100);

            //cout<<"P: "<<P[y][j]<<endl;
            Vwo=(Q*2650)/(2*pi*rwc*P[y][j]);
           // cout<<"\n"<<"vwooo: "<<Vwo;

            float Nds=(Ks*(Cos-Cirs)*rwc*Sigmas)/Vwo;
            //cout<<"\n"<<"Nds"<<Nds;

            float Ndq=(Kq*(Coq-Cirq)*rwc*Sigmaq)/Vwo;
            //cout<<"\n"<<"Ndq"<<Ndq;

            float Nas=(po*Cfi)/(Sigmas*(1-po)*(Cos-Cirs));
            //cout<<"\n"<<"Nas"<<Nas;

            float Naq=(po*Cfi)/(Sigmaq*(1-po)*(Coq-Cirq));
            //cout<<"\n"<<"Naq"<<Naq;
            kd=P[y][2];
            X[1][1]=kd;
            float Xacid=0.082;
            float Vc=pi*(pow(rd,2)-pow(D/2,2))*(1-po)*x;
            float Vacid=Vc/Xacid;
            float Vp=pi*(pow(rd,2)-pow(D/2,2))*(po+x*(1-po));
            float Vt=(Vp+Vacid)*7.48;
            float p=po+(1-po)*x;
            //cout<<"\n"<<"p::"<<p;


            X[2][1]=X[1][1]*pow((p/po),3);
       //cout<<"\n"<<"ite........"<<i<<endl;

       t=.25*z;
       i=floor((Qinj/42)/Qo);

        if(b==1){
        C[1][1][1]=0;C[1][2][1]=1;C[1][3][1]=1;C[1][4][1]=Cos;C[1][5][1]=Coq;C[1][6][1]=po;C[1][7][1]=X[2][1];

        C[1][1][2]=0;C[1][2][2]=1;C[1][3][2]=1;C[1][4][2]=Cos;C[1][5][2]=Coq;C[1][6][2]=po;C[1][7][2]=X[2][1];

        C[1][1][3]=0;C[1][2][3]=1;C[1][3][3]=1;C[1][4][3]=Cos;C[1][5][3]=Coq;C[1][6][3]=po;C[1][7][3]=X[2][1];

        C[1][1][4]=0;C[1][2][4]=1;C[1][3][4]=1;C[1][4][4]=Cos;C[1][5][4]=Coq;C[1][6][4]=po;C[1][7][4]=X[2][1];

        C[1][1][5]=0;C[1][2][5]=1;C[1][3][5]=1;C[1][4][5]=Cos;C[1][5][5]=Coq;C[1][6][5]=po;C[1][7][5]=X[2][1];

        C[1][1][6]=0;C[1][2][6]=1;C[1][3][6]=1;C[1][4][6]=Cos;C[1][5][6]=Coq;C[1][6][6]=po;C[1][7][6]=X[2][1];
        }
        else{
        //cout<<"b: "<<b<<endl;
        C[1][1][1]=C[n][1][1];C[1][2][1]=C[n][2][1];C[1][3][1]=C[n][3][1];C[1][4][1]=C[n][4][1];C[1][5][1]=C[n][5][1];C[1][6][1]=C[n][6][1];C[1][7][1]=C[n][7][1];
        //cout<<C[1][1][1]<<endl;
        C[1][1][2]=C[n][1][2];C[1][2][2]=C[n][2][2];C[1][3][2]=C[n][3][2];C[1][4][2]=C[n][4][2];C[1][5][2]=C[n][5][2];C[1][6][2]=C[n][6][2];C[1][7][2]=C[n][7][2];

        C[1][1][3]=C[n][1][3];C[1][2][3]=C[n][2][3];C[1][3][3]=C[n][3][3];C[1][4][3]=C[n][4][3];C[1][5][3]=C[n][5][3];C[1][6][3]=C[n][6][3];C[1][7][3]=C[n][7][3];

        C[1][1][4]=C[n][1][4];C[1][2][4]=C[n][2][4];C[1][3][4]=C[n][3][4];C[1][4][4]=C[n][4][4];C[1][5][4]=C[n][5][4];C[1][6][4]=C[n][6][4];C[1][7][4]=C[n][7][4];

        C[1][1][5]=C[n][1][5];C[1][2][5]=C[n][2][5];C[1][3][5]=C[n][3][5];C[1][4][5]=C[n][4][5];C[1][5][5]=C[n][5][5];C[1][6][5]=C[n][6][5];C[1][7][5]=C[n][7][5];

        C[1][1][6]=C[n][1][6];C[1][2][6]=C[n][2][6];C[1][3][6]=C[n][3][6];C[1][4][6]=C[n][4][6];C[1][5][6]=C[n][5][6];C[1][6][6]=C[n][6][6];C[1][7][6]=C[n][7][6];
        }

            for (n=1;n<=i+1;n++)
            {
                C[n+1][j][1]=(C[n][j][1]+((po*t)/C[n][j+5][1])*(1*(-(C[n][j][1]-Ci)/2)-(C[n][j][1]*(Nds*C[n][j+1][1]+Ndq*C[n][j+2][1]))));
                if(C[n+1][j][1]>=0.9999)
                    C[n+1][j][1] = 0.9999;
                C[n+1][j+1][1]=(C[n][j+1][1]-(t*Nds*Nas*C[n][j][1]*C[n][j+1][1]*((1-po)/(1-C[n][j+5][1]))));
                C[n+1][j+2][1]=(C[n][j+2][1]-(t*Ndq*Naq*C[n][j][1]*C[n][j+2][1]*((1-po)/(1-C[n][j+5][1]))));
                C[n+1][j+3][1]=((C[n][j+1][1]*(Cos-Cirs))+Cirs);
                C[n+1][j+4][1]=((C[n][j+2][1]*(Coq-Cirq))+Cirq);
                C[n+1][j+5][1]=(C[n][j+5][1]-((1-C[n][j+5][1])*(((C[n+1][j+3][1]-Cos)/C[n+1][j+3][1])+((C[n+1][j+4][1]-Coq)/C[n+1][j+4][1]))));
                C[n+1][j+6][1]=(C[n][j+6][1]*(pow((C[n+1][j+5][1]/C[n][j+5][1]),lab)));


                k=1;
                for( m=r+z;m<=rd;m=m+z)  //r+z   z=2
                {

                tem=(r/m);
                tem1=(pow(tem,2));
    //cout<<"\n"<<":::::"<<tem<<"::::"<<tem1<<"\n";
                C[n+1][j][k+1]=C[n][j][k+1]+((po*t)/C[n][j+5][k+1])*(tem1*(-(C[n][j][k+1]-C[n][j][k])/2)-(C[n][j][k+1]*(Nds*C[n][j+1][k+1]+Ndq*C[n][j+2][k+1])));
                if(C[n+1][j][k+1]>=0.9999)
                    C[n+1][j][k+1] = 0.9999;
                C[n+1][j+1][k+1]=C[n][j+1][k+1]-(t*Nds*Nas*C[n][j][k+1]*C[n][j+1][k+1]*((1-po)/(1-C[n][j+5][k+1])));

                C[n+1][j+2][k+1]=C[n][j+2][k+1]-(t*Ndq*Naq*C[n][j][k+1]*C[n][j+2][k+1]*((1-po)/(1-C[n][j+5][k+1])));

                C[n+1][j+3][k+1]=(C[n][j+1][k+1]*(Cos-Cirs))+Cirs;

                C[n+1][j+4][k+1]=(C[n][j+2][k+1]*(Coq-Cirq))+Cirq;

                C[n+1][j+5][k+1]=C[n][j+5][k+1]-((1-C[n][j+5][k+1])*(((C[n+1][j+3][k+1]-Cos)/C[n+1][j+3][k+1])+((C[n+1][j+4][k+1]-Coq)/C[n+1][j+4][k+1])));

                C[n+1][j+6][k+1]=C[n][j+6][k+1]*pow((C[n+1][j+5][k+1]/C[n][j+5][k+1]),lab);
  //  B[y][k+1]=C[n+1][j][k+1];
    // cout<<"\n"<<y<<k+1<<"::::"<<B[y][k+1];
                k=k+1;

                } //
            }

            if(b==a)
            {

            string depthToDepth = doubleToString(DepthF[y])+"-"+doubleToString(DepthT[y])+" ";


            string AcidPenetrationOutput = depthToDepth;

            //+doubleToString(C[i+1][1][j])+" "+doubleToString(C[i+1][1][j+1])+" "+doubleToString(C[i+1][1][j+2])+" "+doubleToString(C[i+1][1][j+3])+" "+doubleToString(C[i+1][1][j+4])+" "+doubleToString(C[i+1][1][j+5]);

            if(C[i+1][1][j]<=0.01)
                 AcidPenetrationOutput += " "+doubleToString(r+1);
            else if(C[i+1][1][j+1]<=0.01)
                AcidPenetrationOutput += " "+doubleToString(r+3);
            else if(C[i+1][1][j+2]<=0.01)
                AcidPenetrationOutput += " "+doubleToString(r+5);
            else if(C[i+1][1][j+3]<=0.01)
                AcidPenetrationOutput += " "+doubleToString(r+7);
            else if(C[i+1][1][j+4]<=0.01)
                AcidPenetrationOutput += " "+doubleToString(r+9);
            else if(C[i+1][1][j+5]<=0.01)
                AcidPenetrationOutput += " "+doubleToString(r+11);
            AcidPenetration.push_back(AcidPenetrationOutput);
           /* file2<<"\n"<<"layer "<<y;
            file2<<"\n"<<C[i+1][1][j];
            file2<<"\n"<<C[i+1][1][j+1];
            file2<<"\n"<<C[i+1][1][j+2];
            file2<<"\n"<<C[i+1][1][j+3];
            */

            K[y][1]=(log(re/rwc))/((log(re/rwc)/kud[y])+(log((r+z)/r)/C[i+1][7][1])+(log((r+2*z)/(r+z))/C[i+1][7][2])+(log((r+3*z)/(r+2*z))/C[i+1][7][3]));
      //      cout<<K[y][1]<<endl;
            s[y][1]=((kud[y]/K[y][1])-1)*(log(re/rwc));
//P[y][j+1]=K[y][1];
            J[y][1]=(K[y][1]*P[y][1])/(mu*(log(re/rwc)+s[y][1]));

            prodl[y] = (0.00708*K[y][1]*P[y][1]*(ZP[y]-InjP[b]))/(mu*1.115*(log(re/r)-0.75+s[y][1]));
            Production += prodl[y];
    //        cout<<"Production: "<<prodl[y]<<endl;
            //file2<<"\n"<<"skin"<<s[y][1];
            string SkinOutput = depthToDepth+doubleToString(s[y][1]);
            //cout<<SkinOutput<<endl;
            PostStimulationSkin.push_back(SkinOutput);
            //file2<<"\n"<<"productivity"<<J[y][1];
            //file2<<"\n"<<"percentage volume"<<PV[y][1];
            string perVolOutput = depthToDepth+doubleToString(PV[y][1])+" %";
           // cout<<perVolOutput<<endl;
            AcidPlacement.push_back(perVolOutput);
//file<<"\n"<<"k"<<K[y][1];
            sum1=sum1+(K[y][1]*P[y][1]);
            Q1=Qo*((K[y][j]*P[y][j+1])/sum1);
            PV[y][1]=(Q1/Qo)*100;
//file<<"\n"<<y<<"1"<<":::"<<PV[y][1];
            }
       }
   }

  //cout<<"Total Production: "<<Production<<endl;


  double timesteps = ip["NoOfTimepsteps"];

  int tt = 0;
  for(int i=0;i<=timesteps;i++){
    Production = Production * exp(-0.013*tt);
    tt++;
    string PostStimulationProductionOutput = (day>9?"":"0")+doubleToString(day)+"/"+(month>9?"":"0")+doubleToString(month)+"/"+doubleToString(year%100)+"   "+doubleToString(Production);
    PostStimulationProduction.push_back(PostStimulationProductionOutput);
    changeDate(10);
  }


  writestaticData1(file2);

   file2<<"\n";
   file2<<"Acid Placement\n";
   file2<<"\n";
   file2<<"Depth (FT)   % Volume\n\n";
  for(int i=0;i<AcidPlacement.size();i++){
        file2<<AcidPlacement[i];
   }
   file2<<"\n\n/\n";
    file2<<"\n";
    file2<<"Acid Penetration\n\n";
    file2<<"Depth (FT)  Penetration Length (FT)\n\n";
    for(int i=0;i<AcidPenetration.size();i++){
        file2<<AcidPenetration[i]<<"\r";
    }

    file2<<"\n\n/\n";
    file2<<"\nPost Stimulation skin\n\n";
   file2<<"Depth (FT)   Skin\n\n";
   for(int i=0;i<PostStimulationSkin.size();i++){
        file2<<PostStimulationSkin[i]<<"\r";
   }


    file2<<"\n\n/\n\n";
    file2<<"Post Stimulation Production\n\n";
    file2<<"Date   Production (Bbls/d)\n\n";
    for(int i=0;i<PostStimulationProduction.size();i++){
        file2<<PostStimulationProduction[i]<<"\r";
    }
    file2<<"\n\n/\n\n";
    writestaticData2(file2);
}
