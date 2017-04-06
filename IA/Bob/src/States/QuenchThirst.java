package States;

import java.util.Random;

import Omega.Bob;
import Omega.Player;

public class QuenchThirst extends AbstractState<Bob> {

	public static State<Bob> instance;
	Random r;

	public QuenchThirst() {
		this.r = new Random();
	}

	public static State<Bob> getInstance(){
        if(instance == null){
            instance = new QuenchThirst();
        }
        return instance;
    }
	@Override
	public void enter(Player<Bob> b) {
		System.out.println("-----------------------------------");
		System.out.println("Acho que preciso de umas birita!");

	}

	@Override
	public void execute(Player<Bob> b) {
		if (((Bob) b).getThirsty() > 10) {
			int res = r.nextInt(7);
			if (res == 7)
				System.out.println("DESCE AQUELA VODKAZINHA COM RUM DO H�MALAIA!");
			((Bob) b).addThirsty(-res);
		}

		if (((Bob) b).getThirsty() <= 10)
			b.getManager().changeState(EnterMineAndDigForNugget.getInstance());

	}

	@Override
	public void exit(Player<Bob> b) {
		try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
