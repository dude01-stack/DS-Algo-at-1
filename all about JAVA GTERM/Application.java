public class Application {
	
	private BackEnd backEnd;
	private FrontEndGTerm uiGT0;
	private FrontEndGTerm uiGT1;
	private FrontEndConsole uiConsole;

	public Application() {
		this.backEnd = new BackEnd();
		this.uiGT0 = new FrontEndGTerm(this.backEnd);
		this.uiGT1 = new FrontEndGTerm(this.backEnd);
		this.uiConsole = new FrontEndConsole(this.backEnd);
	}

	public static void main(String[] args) {
		Application app = new Application();
		app.uiConsole.showMenu();
	}
}