package my2048;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainState extends BasicGameState{

	private Integer[][] tab;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		tab = new Integer[4][4];
		for(int i=0; i<tab.length;i++){
			for(int j=0; j<tab[i].length;j++){
				tab[i][j] = 0;
			}
		}
		tab[(int) Math.floor(Math.random()*4)][(int) Math.floor(Math.random()*4)]=1;
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)	throws SlickException {
		String rendu = "2048\n\n";
		if(isGameOver()){
			rendu += "Game Over";
		} else {
			for(int i=0; i<tab.length;i++){
				for(int j=0; j<tab[i].length;j++){
					if(tab[i][j] != 0){arg2.drawImage(new Image("img/2048/"+String.valueOf(tab[i][j])+".png").getScaledCopy(64, 64),32+(64*j), 62+(64*i));}
				}
			}
		}
		arg2.drawString(rendu, 0, 0);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)throws SlickException {
		boolean anyMove = false;
		
		
		//TODO : refacto de toute cette partie !!
		if(appuiHaut(arg0)){
			boolean move = true;
			while (move){
				move = false;
				for(int i=0; i<tab.length-1;i++){
					for(int j=0; j<tab[i].length;j++){
						if(tab[i][j]==0 && tab[i+1][j] != 0){
							tab[i][j]=tab[i+1][j];
							tab[i+1][j]=0;
							move=true;
							anyMove=true;
						}	
					}
				}
			}

			for(int i=0; i<tab.length-1;i++){
				for(int j=0; j<tab[i].length;j++){
					if(tab[i+1][j] == tab[i][j] && tab[i][j] != 0){
						tab[i][j]++;
						tab[i+1][j]=0;
						anyMove=true;
					}
				}
			}
			
			move = true;
			while (move){
				move = false;
				for(int i=0; i<tab.length-1;i++){
					for(int j=0; j<tab[i].length;j++){
						if(tab[i][j]==0 && tab[i+1][j] != 0){
							tab[i][j]=tab[i+1][j];
							tab[i+1][j]=0;
							move=true;
							anyMove=true;
						}	
					}
				}
			}
		}
		
		if(appuiBas(arg0)){
			boolean move = true;
			while (move){
				move = false;
				for(int i=3; i>0;i--){
					for(int j=0; j<tab[i].length;j++){
						if(tab[i][j]==0 && tab[i-1][j] != 0){
							tab[i][j]=tab[i-1][j];
							tab[i-1][j]=0;
							move=true;
							anyMove=true;
						}	
					}
				}
			}

			for(int i=3; i>0;i--){
				for(int j=0; j<tab[i].length;j++){
					if(tab[i-1][j] == tab[i][j] && tab[i][j] != 0){
						tab[i][j]++;
						tab[i-1][j]=0;
						anyMove=true;
					}
				}
			}
			
			move = true;
			while (move){
				move = false;
				for(int i=3; i>0;i--){
					for(int j=0; j<tab[i].length;j++){
						if(tab[i][j]==0 && tab[i-1][j] != 0){
							tab[i][j]=tab[i-1][j];
							tab[i-1][j]=0;
							move=true;
							anyMove=true;
						}	
					}
				}
			}
		}
		
		if(appuiGauche(arg0)){
			boolean move = true;
			while (move){
				move = false;
				for(int j=0; j<tab.length-1;j++){
					for(int i=0; i<tab[j].length;i++){
						if(tab[i][j]==0 && tab[i][j+1] != 0){
							tab[i][j]=tab[i][j+1];
							tab[i][j+1]=0;
							move=true;
							anyMove=true;
						}	
					}
				}
			}

			for(int j=0; j<tab.length-1;j++){
				for(int i=0; i<tab[j].length;i++){
					if(tab[i][j+1] == tab[i][j] && tab[i][j] != 0){
						tab[i][j]++;
						tab[i][j+1]=0;
						anyMove=true;
					}
				}
			}
			
			move = true;
			while (move){
				move = false;
				for(int j=0; j<tab.length-1;j++){
					for(int i=0; i<tab[j].length;i++){
						if(tab[i][j]==0 && tab[i][j+1] != 0){
							tab[i][j]=tab[i][j+1];
							tab[i][j+1]=0;
							move=true;
							anyMove=true;
						}	
					}
				}
			}
		}
		
		if(appuiDroite(arg0)){
			boolean move = true;
			while (move){
				move = false;
				for(int j=3; j>0;j--){
					for(int i=0; i<tab[j].length;i++){
						if(tab[i][j]==0 && tab[i][j-1] != 0){
							tab[i][j]=tab[i][j-1];
							tab[i][j-1]=0;
							move=true;
							anyMove=true;
						}	
					}
				}
			}

			for(int j=3; j>0;j--){
				for(int i=0; i<tab[j].length;i++){
					if(tab[i][j-1] == tab[i][j] && tab[i][j] != 0){
						tab[i][j]++;
						tab[i][j-1]=0;
						anyMove=true;
					}
				}
			}
			
			move = true;
			while (move){
				move = false;
				for(int j=3; j>0;j--){
					for(int i=0; i<tab[j].length;i++){
						if(tab[i][j]==0 && tab[i][j-1] != 0){
							tab[i][j]=tab[i][j-1];
							tab[i][j-1]=0;
							move=true;
							anyMove=true;
						}	
					}
				}
			}
		}
		
		if(anyMove){
			addCase();
		}
	}

	private void addCase(){
		int ligne = (int) Math.floor(Math.random()*4);
		int col = (int) Math.floor(Math.random()*4);
		while(tab[ligne][col] != 0){
			ligne = (int) Math.floor(Math.random()*4);
			col = (int) Math.floor(Math.random()*4);
		}
		tab[ligne][col] = 1;
	}
	
	private boolean appuiHaut(GameContainer arg0){
		return arg0.getInput().isKeyDown(Input.KEY_UP) && arg0.getInput().isKeyPressed(Input.KEY_UP);
	}

	private boolean appuiBas(GameContainer arg0){
		return arg0.getInput().isKeyDown(Input.KEY_DOWN) && arg0.getInput().isKeyPressed(Input.KEY_DOWN);
	}

	private boolean appuiGauche(GameContainer arg0){
		return arg0.getInput().isKeyDown(Input.KEY_LEFT) && arg0.getInput().isKeyPressed(Input.KEY_LEFT);
	}

	private boolean appuiDroite(GameContainer arg0){
		return arg0.getInput().isKeyDown(Input.KEY_RIGHT) && arg0.getInput().isKeyPressed(Input.KEY_RIGHT);
	}

	private boolean isGameOver(){
		boolean ret = true;
		for(int i=0; i<tab.length;i++){
			for(int j=0; j<tab[i].length;j++){
				if(tab[i][j] == 0){ret = false;}
				if(i>=1 && tab[i][j] == tab[i-1][j]){ret = false;}
				if(i<=2 && tab[i][j] == tab[i+1][j]){ret = false;}
				if(j>=1 && tab[i][j] == tab[i][j-1]){ret = false;}
				if(j<=2 && tab[i][j] == tab[i][j+1]){ret = false;}
			}
		}
		return ret;
	}

	@Override
	public int getID() {return 0;}

}
