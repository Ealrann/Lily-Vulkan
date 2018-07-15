package org.sheepy.vulkan.imgui;

import org.sheepy.vulkan.window.Window;

import glm_.vec2.Vec2;
import glm_.vec4.Vec4;
import imgui.Col;
import imgui.Cond;
import imgui.ImGui;
import imgui.Style;
import kotlin.reflect.KMutableProperty0;

public class UIDescriptor
{
	private Window window;

	public class GuiInfos
	{
		public String title = "Totoa";

		public float frameTimer = 12f;

		float[] cameraPosition = {
				12.0f, 13f, 14f
		};
		float[] cameraRotation = {
				12.0f, 13f, 14f
		};

		KMutableProperty0<Boolean> displayModels = new BMutable();
		KMutableProperty0<Boolean> displayLogos = new BMutable();

		KMutableProperty0<Boolean> displayBackground = new BMutable();
		KMutableProperty0<Boolean> animateLight = new BMutable();
		float[] lightSpeed = {
				0.25f
		};
		float[] frameTimes = new float[50];
		float frameTimeMin = 9999.0f, frameTimeMax = 0.0f;
		float lightTimer = 0.0f;
	}

	public GuiInfos infos = new GuiInfos();

	public UIDescriptor(Window window)
	{
		this.window = window;
	}

	public void configureStyle(Style style)
	{
		style.getColors();

		style.getColors().set(Col.TitleBg.getI(), new Vec4(1.0f, 0.0f, 0.0f, 0.6f));
		style.getColors().set(Col.TitleBgActive.getI(), new Vec4(1.0f, 0.0f, 0.0f, 0.8f));
		style.getColors().set(Col.MenuBarBg.getI(), new Vec4(1.0f, 0.0f, 0.0f, 0.4f));
		style.getColors().set(Col.Header.getI(), new Vec4(1.0f, 0.0f, 0.0f, 0.4f));
		style.getColors().set(Col.CheckMark.getI(), new Vec4(0.0f, 1.0f, 0.0f, 1.0f));
	}

	public void newFrame(ImGui imgui)
	{
		imgui.setNextWindowPos(new Vec2(650, 20), Cond.FirstUseEver, new Vec2(0, 0));
		imgui.setNextWindowSize(new Vec2(200, 200), Cond.FirstUseEver);
		imgui.begin("Example settings", new boolean[1], 0);
		imgui.checkbox("Render models", infos.displayModels);
		imgui.checkbox("Display logos", infos.displayLogos);
		imgui.checkbox("Display background", infos.displayBackground);
		imgui.checkbox("Animate light", infos.animateLight);
		imgui.sliderFloat("Light speed", infos.lightSpeed, 0.1f, 1.0f, "", 0);
		imgui.end();

	}

	public int[] getSize()
	{
		return window.getSurface().size;
	}
}
