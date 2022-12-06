package org.sheepy.lily.vulkan.nuklear.font;

import java.util.List;

public interface IFontTableInfo
{
	boolean contains(int codepoint);

	List<TableData> getTableData();

	float getCodepointHMetric(int codePoint);
	float getVMetric();
	float getCodepointKernAdvance(int codePoint, int nextCodePoint);

	record TableData(int codepoint, float hMetric)
	{
	}
}
