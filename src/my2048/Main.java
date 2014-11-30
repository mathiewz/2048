package my2048;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame{

	/** Le constructeur de la classe.*/
	public Main() {
		super("2048");
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new MainState());
	}

	/** 
	 * Démarre le jeu.
	 * @param args les arguments de démarage
	 */

	public static void main(String[] args){
		int width = 320;
		int height = 350;
		//fullScreen = false;		Inputs.initImputs();
		try  
		{  
			AppGameContainer container = new AppGameContainer(new Main());
			container.setDisplayMode(width, height, false);// fen�tre de 800 par 600 fullscreen =false !!  
			container.setShowFPS(false);//on choisit si on veut voir le nombre de frame/secondes
			container.setTargetFrameRate(60);// on régle les FPS
			container.start();
		}                         
		catch (SlickException e) {e.printStackTrace();}
	}

}
