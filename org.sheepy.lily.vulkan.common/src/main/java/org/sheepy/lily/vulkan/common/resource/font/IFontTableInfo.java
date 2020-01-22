package org.sheepy.lily.vulkan.common.resource.font;

import java.util.List;

public interface IFontTableInfo
{

	int getLoadedCharCount();
	int indexOf(int codepoint);
	boolean contains(int codepoint);

	List<TableData> getTableData();

	float getCodepointHMetric(int codePoint);
	float getVMetric();
	float getCodepointKernAdvance(int codePoint, int nextCodePoint);

	static final class TableData
	{
		public final int codepoint;
		public final float hMetric;

		public TableData(int codepoint, float hMetric)
		{
			this.codepoint = codepoint;
			this.hMetric = hMetric;
		}
	}
}
