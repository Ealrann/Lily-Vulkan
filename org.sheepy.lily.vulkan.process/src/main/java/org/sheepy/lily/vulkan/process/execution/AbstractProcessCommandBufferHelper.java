package org.sheepy.lily.vulkan.process.execution;

import org.sheepy.lily.vulkan.core.execution.AbstractCommandBufferHelper;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractProcessCommandBufferHelper extends AbstractCommandBufferHelper
{
	private final List<ECommandStage> stages;
	private final RecordInfo recordInfo;

	public AbstractProcessCommandBufferHelper(final ExecutionContext context,
											  final List<ECommandStage> stages,
											  final RecordInfo recordInfo)
	{
		super(context);
		this.stages = List.copyOf(stages);
		this.recordInfo = recordInfo;
	}

	public List<RecordContext> record(List<IRecordableAdapter> recordables, ProcessContext context)
	{
		final List<RecordContext> res = new ArrayList<>(stages.size());

		try
		{
			for (int i = 0; i < stages.size(); i++)
			{
				final var stage = stages.get(i);
				final var recordContext = new RecordContext(context,
															vkCommandBuffer,
															stage,
															recordInfo.executionID,
															recordInfo.recordIndex);

				recordContext.stackPush();
				start(stage);
				recordStage(recordables, recordContext);
				end(stage);
				recordContext.stackPop();

				res.add(recordContext);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}

		return res;
	}

	protected abstract void recordStage(List<IRecordableAdapter> recordables, final RecordContext recordContext);

	public record RecordInfo(int executionID, int recordIndex)
	{
	}
}
