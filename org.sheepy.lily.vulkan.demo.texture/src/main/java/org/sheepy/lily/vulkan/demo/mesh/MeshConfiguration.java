package org.sheepy.lily.vulkan.demo.mesh;

import org.joml.Vector2ic;
import org.sheepy.vulkan.model.enumeration.EFrontFace;

import java.nio.ByteBuffer;

public class MeshConfiguration
{
	public String texturePath = null;
	public String vertexShaderPath = "triangle.vert.spv";
	public String fragmentShaderPath = "triangle.frag.spv";
	public Module module = MeshConfiguration.class.getModule();

	public boolean useCamera = false;
	public boolean depth = false;

	public EFrontFace rasterizerFrontFace = EFrontFace.CLOCKWISE;

	public final int width;
	public final int height;
	public boolean useTexture = false;

	public int indexCount;
	public ByteBuffer vertexData;
	public ByteBuffer indexData;

	public MeshConfiguration(AbstractMeshBuilder meshBuilder, Vector2ic size)
	{
		this.width = size.x();
		this.height = size.y();

		vertexData = meshBuilder.getVertexData();
		indexData = meshBuilder.getIndexData();
		indexCount = meshBuilder.getIndexCount();
	}
}
