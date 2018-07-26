package org.sheepy.vulkan.pipeline.graphic;

/**
 * @author ealrann
 *
 */
public interface IGraphicProcessUnit
{

	/**
	 * @return true if the process unit is dirty
	 */
	boolean update();
}
