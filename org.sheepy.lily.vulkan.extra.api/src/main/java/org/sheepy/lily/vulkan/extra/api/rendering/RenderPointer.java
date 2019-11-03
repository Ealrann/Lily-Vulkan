package org.sheepy.lily.vulkan.extra.api.rendering;

public final class RenderPointer
{
	public final int triangle;
	public final int instance;
	public final int drawcall;

	public RenderPointer(int triangle, int instance, int drawcall)
	{
		this.triangle = triangle;
		this.instance = instance;
		this.drawcall = drawcall;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + drawcall;
		result = prime * result + instance;
		result = prime * result + triangle;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final RenderPointer other = (RenderPointer) obj;
		if (drawcall != other.drawcall) return false;
		if (instance != other.instance) return false;
		if (triangle != other.triangle) return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "RenderPointer [triangle="
				+ triangle
				+ ", instance="
				+ instance
				+ ", drawcall="
				+ drawcall
				+ "]";
	}
}