package com.application;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate-drink-amount")
public class CalculateDrinkAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//make class variables
	double initialBAC;
	double expendableBAC = 0.015; //how much BAC is reduced per hour
	double finalBAC;
	int drinks;

    public CalculateDrinkAmount() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getServletContext().getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		//Retrieve values from form
		String gender = request.getParameter("gender");
		String weight = request.getParameter("weight");
		String drinkTime = request.getParameter("drink-time");
		String goal = request.getParameter("goal");
		String unit = request.getParameter("unit");
		
		//Parse int the weight and drinkTime so that they are no longer strings and can be manipulated
		int weightNum = Integer.parseInt(weight);
		int drinkTimeNum = Integer.parseInt(drinkTime);
		
		//convert from kg to lbs if kg was used
		if(unit.equals("kg")){
			weightNum *= 2.2046;
		}
		
		//Enable them to be printed out in a JSP
		request.setAttribute("gender", gender);
		request.setAttribute("weight", weightNum);
		request.setAttribute("time", drinkTime);
		request.setAttribute("goal", goal);

		//Set initial drink amount
		//If the person plans on drinking for at least an hour or more, set the initial drink amount to the total hours they plan on drinking
		//Otherwise, set the initial drink amount to zero
		if(drinkTimeNum >= 1){
			drinks = drinkTimeNum;
		} else {
			drinks = 0;
		}
		
		//Calculate initial BAC levels based on gender and weight
		if(gender.equals("male")){
			
			if(weightNum <= 100){
				
				initialBAC = 0.0435;
				
			} else if(weightNum > 100 && weightNum < 125){
				
				double base = 0.0435;
				double rate = 0.00036 * 5;
				
				switch(weightNum){
				case 101:
				case 102:
				case 103:
				case 104:
					initialBAC = base;
					break;
				case 105:
				case 106:
				case 107:
				case 108:
				case 109:
					initialBAC = base - rate;
					break;
				case 110:
				case 111:
				case 112:
				case 113:
				case 114:
					initialBAC = base - (rate * 2);
					break;
				case 115:
				case 116:
				case 117:
				case 118:
				case 119:
					initialBAC = base - (rate * 3);
					break;
				case 120:
				case 121:
				case 122:
				case 123:
				case 124:
					initialBAC = base - (rate * 4);
					break;
				} 
				
			} else if(weightNum >= 125 && weightNum < 150){
				
				double base = 0.0345;
				double rate = 0.0002 * 5;
			
				switch(weightNum){
				case 125:
				case 126:
				case 127:
				case 128:
				case 129:
					initialBAC = base;
					break;
				case 130:
				case 131:
				case 132:
				case 133:
				case 134:
					initialBAC = base - rate;
					break;
				case 135:
				case 136:
				case 137:
				case 138:
				case 139:
					initialBAC = base - (rate * 2);
					break;
				case 140:
				case 141:
				case 142:
				case 143:
				case 144:
					initialBAC = base - (rate * 3);
					break;
				case 145:
				case 146:
				case 147:
				case 148:
				case 149:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else if(weightNum >= 150 && weightNum < 175){
				
				double base = 0.0295;
				double rate = 0.00016 * 5;
			
				switch(weightNum){
				case 150:
				case 151:
				case 152:
				case 153:
				case 154:
					initialBAC = base;
					break;
				case 155:
				case 156:
				case 157:
				case 158:
				case 159:
					initialBAC = base - rate;
					break;
				case 160:
				case 161:
				case 162:
				case 163:
				case 164:
					initialBAC = base - (rate * 2);
					break;
				case 165:
				case 166:
				case 167:
				case 168:
				case 169:
					initialBAC = base - (rate * 3);
					break;
				case 170:
				case 171:
				case 172:
				case 173:
				case 174:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else if(weightNum >= 175 && weightNum < 200){
				
				double base = 0.0255;
				double rate = 0.00012 * 5;
			
				switch(weightNum){
				case 175:
				case 176:
				case 177:
				case 178:
				case 179:
					initialBAC = base;
					break;
				case 180:
				case 181:
				case 182:
				case 183:
				case 184:
					initialBAC = base - rate;
					break;
				case 185:
				case 186:
				case 187:
				case 188:
				case 189:
					initialBAC = base - (rate * 2);
					break;
				case 190:
				case 191:
				case 192:
				case 193:
				case 194:
					initialBAC = base - (rate * 3);
					break;
				case 195:
				case 196:
				case 197:
				case 198:
				case 199:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else if(weightNum >= 200 && weightNum < 225){
				
				double base = 0.0225;
				double rate = 0.00012 * 5;
			
				switch(weightNum){
				case 200:
				case 201:
				case 202:
				case 203:
				case 204:
					initialBAC = base;
					break;
				case 205:
				case 206:
				case 207:
				case 208:
				case 209:
					initialBAC = base - rate;
					break;
				case 210:
				case 211:
				case 212:
				case 213:
				case 214:
					initialBAC = base - (rate * 2);
					break;
				case 215:
				case 216:
				case 217:
				case 218:
				case 219:
					initialBAC = base - (rate * 3);
					break;
				case 220:
				case 221:
				case 222:
				case 223:
				case 224:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else if(weightNum >= 225 && weightNum < 250){
				
				double base = 0.0195;
				double rate = 0.00008 * 5;
			
				switch(weightNum){
				case 225:
				case 226:
				case 227:
				case 228:
				case 229:
					initialBAC = base;
					break;
				case 230:
				case 231:
				case 232:
				case 233:
				case 234:
					initialBAC = base - rate;
					break;
				case 235:
				case 236:
				case 237:
				case 238:
				case 239:
					initialBAC = base - (rate * 2);
					break;
				case 240:
				case 241:
				case 242:
				case 243:
				case 244:
					initialBAC = base - (rate * 3);
					break;
				case 245:
				case 246:
				case 247:
				case 248:
				case 249:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else if(weightNum >= 250 && weightNum < 275){
				
				double base = 0.0175;
				double rate = 0.00008 * 5;
			
				switch(weightNum){
				case 250:
				case 251:
				case 252:
				case 253:
				case 254:
					initialBAC = base;
					break;
				case 255:
				case 256:
				case 257:
				case 258:
				case 259:
					initialBAC = base - rate;
					break;
				case 260:
				case 261:
				case 262:
				case 263:
				case 264:
					initialBAC = base - (rate * 2);
					break;
				case 265:
				case 266:
				case 267:
				case 268:
				case 269:
					initialBAC = base - (rate * 3);
					break;
				case 270:
				case 271:
				case 272:
				case 273:
				case 274:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else {
				
				double base = 0.0175;
				double rate = 0.00008 * 5;
				
				initialBAC = base - (rate * 5);
			}
		
		} else { //for females
			
			if(weightNum <= 100){
				
				initialBAC = 0.0505;
				
			} else if(weightNum > 100 && weightNum < 125){
				
				double base = 0.0505;
				double rate = 0.0004 * 5;
				
				switch(weightNum){
				case 101:
				case 102:
				case 103:
				case 104:
					initialBAC = base;
					break;
				case 105:
				case 106:
				case 107:
				case 108:
				case 109:
					initialBAC = base - rate;
					break;
				case 110:
				case 111:
				case 112:
				case 113:
				case 114:
					initialBAC = base - (rate * 2);
					break;
				case 115:
				case 116:
				case 117:
				case 118:
				case 119:
					initialBAC = base - (rate * 3);
					break;
				case 120:
				case 121:
				case 122:
				case 123:
				case 124:
					initialBAC = base - (rate * 4);
					break;
				} 
				
			} else if(weightNum >= 125 && weightNum < 150){
				
				double base = 0.0405;
				double rate = 0.00024 * 5;
			
				switch(weightNum){
				case 125:
				case 126:
				case 127:
				case 128:
				case 129:
					initialBAC = base;
					break;
				case 130:
				case 131:
				case 132:
				case 133:
				case 134:
					initialBAC = base - rate;
					break;
				case 135:
				case 136:
				case 137:
				case 138:
				case 139:
					initialBAC = base - (rate * 2);
					break;
				case 140:
				case 141:
				case 142:
				case 143:
				case 144:
					initialBAC = base - (rate * 3);
					break;
				case 145:
				case 146:
				case 147:
				case 148:
				case 149:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else if(weightNum >= 150 && weightNum < 175){
				
				double base = 0.0345;
				double rate = 0.0002 * 5;
			
				switch(weightNum){
				case 150:
				case 151:
				case 152:
				case 153:
				case 154:
					initialBAC = base;
					break;
				case 155:
				case 156:
				case 157:
				case 158:
				case 159:
					initialBAC = base - rate;
					break;
				case 160:
				case 161:
				case 162:
				case 163:
				case 164:
					initialBAC = base - (rate * 2);
					break;
				case 165:
				case 166:
				case 167:
				case 168:
				case 169:
					initialBAC = base - (rate * 3);
					break;
				case 170:
				case 171:
				case 172:
				case 173:
				case 174:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else if(weightNum >= 175 && weightNum < 200){
				
				double base = 0.0295;
				double rate = 0.00012 * 5;
			
				switch(weightNum){
				case 175:
				case 176:
				case 177:
				case 178:
				case 179:
					initialBAC = base;
					break;
				case 180:
				case 181:
				case 182:
				case 183:
				case 184:
					initialBAC = base - rate;
					break;
				case 185:
				case 186:
				case 187:
				case 188:
				case 189:
					initialBAC = base - (rate * 2);
					break;
				case 190:
				case 191:
				case 192:
				case 193:
				case 194:
					initialBAC = base - (rate * 3);
					break;
				case 195:
				case 196:
				case 197:
				case 198:
				case 199:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else if(weightNum >= 200 && weightNum < 225){
				
				double base = 0.0265;
				double rate = 0.00016 * 5;
			
				switch(weightNum){
				case 200:
				case 201:
				case 202:
				case 203:
				case 204:
					initialBAC = base;
					break;
				case 205:
				case 206:
				case 207:
				case 208:
				case 209:
					initialBAC = base - rate;
					break;
				case 210:
				case 211:
				case 212:
				case 213:
				case 214:
					initialBAC = base - (rate * 2);
					break;
				case 215:
				case 216:
				case 217:
				case 218:
				case 219:
					initialBAC = base - (rate * 3);
					break;
				case 220:
				case 221:
				case 222:
				case 223:
				case 224:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else if(weightNum >= 225 && weightNum < 250){
				
				double base = 0.0225;
				double rate = 0.00008 * 5;
			
				switch(weightNum){
				case 225:
				case 226:
				case 227:
				case 228:
				case 229:
					initialBAC = base;
					break;
				case 230:
				case 231:
				case 232:
				case 233:
				case 234:
					initialBAC = base - rate;
					break;
				case 235:
				case 236:
				case 237:
				case 238:
				case 239:
					initialBAC = base - (rate * 2);
					break;
				case 240:
				case 241:
				case 242:
				case 243:
				case 244:
					initialBAC = base - (rate * 3);
					break;
				case 245:
				case 246:
				case 247:
				case 248:
				case 249:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else if(weightNum >= 250 && weightNum < 275){
				
				double base = 0.0205;
				double rate = 0.00008 * 5;
			
				switch(weightNum){
				case 250:
				case 251:
				case 252:
				case 253:
				case 254:
					initialBAC = base;
					break;
				case 255:
				case 256:
				case 257:
				case 258:
				case 259:
					initialBAC = base - rate;
					break;
				case 260:
				case 261:
				case 262:
				case 263:
				case 264:
					initialBAC = base - (rate * 2);
					break;
				case 265:
				case 266:
				case 267:
				case 268:
				case 269:
					initialBAC = base - (rate * 3);
					break;
				case 270:
				case 271:
				case 272:
				case 273:
				case 274:
					initialBAC = base - (rate * 4);
					break;
				}
				
			} else {
				
				double base = 0.0205;
				double rate = 0.00008 * 5;
				
				initialBAC = base - (rate * 5);
			}
		
		}
		
		//determine finalBAC
		//if the drink time is less than an hour, their initialBAC (after one drink) is also their final BAC
		//if they plan to drink for more than an hour, their initialBAC wears off with each hour
		if(drinkTimeNum < 1){
			finalBAC = initialBAC;
		} else {
			finalBAC = ((initialBAC - expendableBAC) * drinkTimeNum) + initialBAC;
		}
		
		//calculate alloted drink amount based on BAC level
		// create a new variable which will start the same as the final blood alcohol level
		// this new variable keeps changing, but we need the initial finalBAC variable to
		// remain the same so it can keep adding to the new variable
		double BAC = finalBAC;

		// Set message if goal is to not get drunk
		if(goal.equals("drunk")){
			//Allow for drinks so long as it does not surpass limit.
			if(finalBAC > 0.05){
				drinks -= 1;
			} else {
				while(BAC < 0.04){
					BAC += initialBAC;
					drinks += 1;
				}
				// don't risk getting past the drunk limit - but if it's been an hour, your BAC lowers
			}
			
			if(drinks < 0){
				drinks = 0;
			}
		} 
		
		// Set message if goal is to not get sick
		else if(goal.equals("sick")){
			//Allow for drinks so long as it does not surpass limit.
			if(finalBAC > 0.16){
				drinks -= 1;
			} else {
				while(BAC < 0.16){
					BAC += initialBAC;
					drinks += 1;	
				}
			}
			
			if(drinks < 0){
				
				drinks = 0;
			}
		}
		
		//Make drinks into a String
		String drinkAmount = Integer.toString(drinks);
		//create a session attribute for drinks
		request.setAttribute("drinks", drinkAmount);
		
		String initial = Double.toString(initialBAC);
		request.setAttribute("initial", initial);
		
		String end = Double.toString(finalBAC);
		request.setAttribute("final", end);
		
		request.setAttribute("yes", BAC);
		
		doGet(request, response);
	}

}
