final int screenWidth = 200;
final int screenHeight = 200;
void initialize(){
	addScreen("mylevel", new MyLevel(sreenWidth, screenHeight));
}

class MyLevel extends Level {
	MyLevel(float levelWidth, float levelHeight) {
		super(levelWidth, levelHeight);
	}
}

class MyLevelLayer extends LevelLayer {
 MyLevelLayer(Lavel owner){
  super(owner);
  color blueishColor = color(0,130,255);
  setBackgtoundColor(blueishColor);
  MyThingy mt = new MyThingy();
  mt.setPosition(width/2, height/2);
  addPlayer(mt);
  MyEnemy me = new MyEnemy();
  addInteractor(me);
  addBoundary(new Boundary(0,height, width,height));
  addBoundary(new Boundary(width,height, width,0));
  addBoundary(new Boundary(width,0,0,0));
  addBoundary(new Boundary(0,0,0,height));
 }
}

class MyLevel extends Level {
 MyLeel(float levelWidth, float levelHeight){
  super(levelWidth, levelWidth);
  addScreenLayer("my lvel layer", new MyLevelLayer(this));
 }
}

class MyThingy extends Player{
 . . .
}

MyThingy() {
 super("thingy");
 setStates();
 handleKey('W');
 handleKey('A');
 handleKey('S');
 handleKey('D');
 setImpulseCoefficients(0.75,0.75);
}

void setStates(){
 addState(new State("idle", "idle.gif"));
}

void handleInput() {
 if(isKeyDown('W')) { addImpulse(0,-1);}
 if(isKeyDown('A')) { addImpulse(-1,0);}
 if(isKeyDown('D')) { addImpulse(1,0);}
 if(isKeyDown('S')) { addImpulse(0,1);}
}

class MyEnemy extends Interactor implements Traker{
 MyEnemy() {
  super("enemy");
  setStates();
 }
 
 void setStates(){
  addState(new State("idle", "idle_enemy.gif"));
 }
 
 void track(Actor actor, float x, float y, float w, float h) {
  GenericTracker.track(this, actor, 0.05);
 }
}

interface Tracker {
 void track(Actor actor, float vx, float vy, float vw, flaot vh);
}

void track(Actor actor float vx, float vy, float vw, float vh) {
 GenericTracker.track(this, actor, 0.05);
}
