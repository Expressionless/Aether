package data.helpers;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class BobRoss {

	public static final int WIDTH = 1280, HEIGHT = 720;
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

	public static TrueTypeFont MENU_FONT;

	public static void beginSession() {
		Display.setTitle("Aether");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		MENU_FONT = prepareFont("Times New Roman", 24);

	}

	public static void paintRect(float x, float y, float width, float height) {
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + width, y);
		glVertex2f(x + width, y + height);
		glVertex2f(x, y + height);
		glEnd();
	}

	public static void paintRectOutline(float x, float y, float width, float height) {
		paintLine(x,y,x+width,y); //top
		paintLine(x,y,x,y+height); //left
		paintLine(x+width, y, x+width, y+height); //right
		paintLine(x,y+height, x+width, y+height); //bottom
	}
	
	public static void paintLine(float x1, float y1, float x2, float y2) {
		glBegin(GL_LINES);
		glVertex2f(x1, y1);
		glVertex2f(x2, y2);
		glEnd();
	}

	public static void drawQuadTex(Texture tex, float x, float y, float width, float height) {
		tex.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity(); // TESt
	}

	public static Texture loadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tex;
	}

	public static Texture quickLoad(String name) {
		Texture tex = null;
		tex = loadTexture("res/" + name + ".png", "PNG");
		return tex;
	}

	public static TrueTypeFont prepareFont(String fontName, int size) {

		TrueTypeFont font;
		Font awtFont = new Font(fontName, Font.BOLD, size); // name, style (PLAIN, BOLD, or ITALIC), size
		font = new TrueTypeFont(awtFont, false); // base Font, anti-aliasing true/false
		return font;

	}

	public static void drawText(String text, float x, float y) {
		MENU_FONT.drawString(x, y, text, Color.white);
	}
	public static void drawText(String text, float x, float y, TrueTypeFont font) {
		font.drawString(x, y, text, Color.white);
	}
}
