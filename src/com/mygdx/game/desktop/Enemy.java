package com.mygdx.game.desktop;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Enemy {

	public Texture cactusImg;
	public Texture mummyImg;
	private Vector2 renderPos;
	private Vector2 pos;
	private float xOldPos, yOldPos, xOldRenderPos, yOldRenderPos;
	private final int WIDTH = 90;
	private final int HEIGHT = 170;
	private float time;
	private int direction = 0;
	private double speed;
	private boolean coll;
	private Player player;
	private int level;
	private Vector2 notePos;
	private Random r;

	public Enemy(Vector2 renderPos, Vector2 pos) {
		cactusImg = new Texture(Gdx.files.internal("cactus.png"));
		mummyImg = new Texture(Gdx.files.internal("mummy.png"));
		this.pos = pos;
		this.renderPos = renderPos;
		time = 0;
		speed = 0.5;
		coll = false;
		level = 1;
		xOldPos = pos.x;
		yOldPos = pos.y;
		notePos = new Vector2();
		xOldRenderPos = renderPos.x;
		yOldRenderPos = renderPos.y;
		r = new Random();
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
//	public void render(SpriteBatch batch) {
//		batch.draw(cactusImg, renderPos.x, renderPos.y);
//	}

	public void update(float delta) {
		xOldPos = pos.x;
		yOldPos = pos.y;

		xOldRenderPos = renderPos.x;
		yOldRenderPos = renderPos.y;
		time += delta;
		if (time > 0.3f) {
			move();
			time = 0;
		}

	}

	public void move() {

		if (player.getPos().x > pos.x) {
			renderPos.x -= 32 * speed;
			renderPos.y += 16 * speed;
			pos.x += 1 * speed;
		} else {
			renderPos.x += 32 * speed;
			renderPos.y -= 16 * speed;
			pos.x -= 1 * speed;
		}
		if (player.getPos().y > pos.y) {
			renderPos.x += 32 * speed;
			renderPos.y += 16 * speed;
			pos.y += 1 * speed;

		} else {
			renderPos.x -= 32 * speed;
			renderPos.y -= 16 * speed;
			pos.y -= 1 * speed;
		}

	}

	public void setNotePos(Vector2 notePos) {
		this.notePos = notePos;
	}

	public Vector2 getNotePos() {
		return notePos;
	}

	public void randomMove() {
		int random = r.nextInt() * 4;

		renderPos.x -= 32 * speed;
		renderPos.y += 16 * speed;
		pos.x += 1 * speed;

		renderPos.x += 32 * speed;
		renderPos.y += 16 * speed;
		pos.y += 1 * speed;

	}

	public Vector2 getRenderPos() {
		return renderPos;
	}

	public Vector2 getPos() {
		return pos;
	}

	public void setRenderPos(float x, float y) {
		this.renderPos.x = x;
		this.renderPos.y = y;
	}

	public void setPos(float x, float y) {
		this.pos.x = x;
		this.pos.y = y;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public Texture getTexture(int level) {
		if (level == 1) {
			return cactusImg;
		} else if (level == 2) {
			return mummyImg;
		} else {
			return null;
		}
	}

	public Vector2 getOldPos() {
		Vector2 oldPos = new Vector2(xOldPos, yOldPos);
		return oldPos;
	}

	public Vector2 getOldRenderPos() {
		Vector2 oldRenderPos = new Vector2(xOldRenderPos, yOldRenderPos);
		return oldRenderPos;
	}

	public String name() {
		return "Cactus";
	}

	public void setColl(boolean coll) {
		this.coll = coll;
	}

	public boolean getColl() {
		return coll;
	}
}
