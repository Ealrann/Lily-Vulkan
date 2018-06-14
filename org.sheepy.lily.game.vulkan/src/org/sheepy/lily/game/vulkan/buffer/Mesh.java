package org.sheepy.lily.game.vulkan.buffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.lily.game.vulkan.shader.Shader;

public class Mesh
{
	private IndexBuffer buffer;
	private List<Shader> shaders = new ArrayList<>();

	public Mesh(IndexBuffer buffer, List<Shader> shaders)
	{
		this.buffer = buffer;
		this.shaders = Collections.unmodifiableList(new ArrayList<>(shaders));
	}

	public void free()
	{
		buffer.free();
		for (Shader shader : shaders)
		{
			shader.destroy();
		}
	}

	public List<Shader> getShaders()
	{
		return shaders;
	}

	public IndexBuffer getIndexBuffer()
	{
		return buffer;
	}
}
