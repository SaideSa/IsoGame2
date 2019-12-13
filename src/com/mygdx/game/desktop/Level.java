package com.mygdx.game.desktop;

import java.util.ArrayList;

public class Level {
	IsometricRenderer renderer;
	Player player;
	ArrayList<Key> keys;
	ArrayList<Enemy> enemy;
	
	public Level(IsometricRenderer isoRend, Player p, ArrayList<Key> k) {
		renderer = isoRend;
		player = p;
		keys = k;
	}
	
	public void level1() {
		renderer.fillMap(1);
		renderer.setLevel(1);
		player.playerSetFirstPos(renderer.MAP_SIZE, renderer.TILE_WIDTH, renderer.TILE_HEIGHT);
		renderer.setPlayerPos(player.getPos());
		renderer.generateEnvironment(1);
		keys = renderer.createKeys(1);
		this.enemy = renderer.createEnemy(3);
	}
	
	public void level2() {
		renderer.ground.clear();
		renderer.envObject.clear();
		keys.clear();
		enemy.clear();
		renderer.setLevel(2);
		
		renderer.fillMap(2);
		player.playerSetFirstPos(renderer.MAP_SIZE, renderer.TILE_WIDTH, renderer.TILE_HEIGHT);
		renderer.setPlayerPos(player.getPos());
		renderer.generateEnvironment(2);
		keys = renderer.createKeys(4);
		this.enemy = renderer.createEnemy(3);
		
	}
	
	public ArrayList<Key> getKeyList(){
		return keys;
	}
	
	public ArrayList<Enemy> getCactusList(){
		return enemy;
	}
	
	
}
