/**
 */
package org.sheepy.vulkan.model.process.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.vulkan.model.process.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.process.ProcessPackage
 * @generated
 */
public class ProcessSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProcessPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = ProcessPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case ProcessPackage.CONFIGURATION:
			{
				Configuration configuration = (Configuration)theEObject;
				T1 result = caseConfiguration(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.GRAPHIC_CONFIGURATION:
			{
				GraphicConfiguration graphicConfiguration = (GraphicConfiguration)theEObject;
				T1 result = caseGraphicConfiguration(graphicConfiguration);
				if (result == null) result = caseConfiguration(graphicConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.RENDER_PASS_INFO:
			{
				RenderPassInfo renderPassInfo = (RenderPassInfo)theEObject;
				T1 result = caseRenderPassInfo(renderPassInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.SUBPASS_DEPENDENCY:
			{
				SubpassDependency subpassDependency = (SubpassDependency)theEObject;
				T1 result = caseSubpassDependency(subpassDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ATTACHMENT_DESCRIPTION:
			{
				AttachmentDescription attachmentDescription = (AttachmentDescription)theEObject;
				T1 result = caseAttachmentDescription(attachmentDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.COLOR_DOMAIN:
			{
				ColorDomain colorDomain = (ColorDomain)theEObject;
				T1 result = caseColorDomain(colorDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_PROCESS_POOL:
			{
				AbstractProcessPool<?> abstractProcessPool = (AbstractProcessPool<?>)theEObject;
				T1 result = caseAbstractProcessPool(abstractProcessPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.COMPUTE_PROCESS_POOL:
			{
				ComputeProcessPool computeProcessPool = (ComputeProcessPool)theEObject;
				T1 result = caseComputeProcessPool(computeProcessPool);
				if (result == null) result = caseAbstractProcessPool(computeProcessPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.GRAPHIC_PROCESS_POOL:
			{
				GraphicProcessPool graphicProcessPool = (GraphicProcessPool)theEObject;
				T1 result = caseGraphicProcessPool(graphicProcessPool);
				if (result == null) result = caseAbstractProcessPool(graphicProcessPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_PROCESS:
			{
				AbstractProcess abstractProcess = (AbstractProcess)theEObject;
				T1 result = caseAbstractProcess(abstractProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.GRAPHIC_PROCESS:
			{
				GraphicProcess graphicProcess = (GraphicProcess)theEObject;
				T1 result = caseGraphicProcess(graphicProcess);
				if (result == null) result = caseAbstractProcess(graphicProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.COMPUTE_PROCESS:
			{
				ComputeProcess computeProcess = (ComputeProcess)theEObject;
				T1 result = caseComputeProcess(computeProcess);
				if (result == null) result = caseAbstractProcess(computeProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.IPROCESS_UNIT:
			{
				IProcessUnit iProcessUnit = (IProcessUnit)theEObject;
				T1 result = caseIProcessUnit(iProcessUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PIPELINE_BARRIER:
			{
				PipelineBarrier pipelineBarrier = (PipelineBarrier)theEObject;
				T1 result = casePipelineBarrier(pipelineBarrier);
				if (result == null) result = caseIProcessUnit(pipelineBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.BUFFER_BARRIER:
			{
				BufferBarrier bufferBarrier = (BufferBarrier)theEObject;
				T1 result = caseBufferBarrier(bufferBarrier);
				if (result == null) result = casePipelineBarrier(bufferBarrier);
				if (result == null) result = caseIProcessUnit(bufferBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_IMAGE_BARRIER:
			{
				AbstractImageBarrier abstractImageBarrier = (AbstractImageBarrier)theEObject;
				T1 result = caseAbstractImageBarrier(abstractImageBarrier);
				if (result == null) result = casePipelineBarrier(abstractImageBarrier);
				if (result == null) result = caseIProcessUnit(abstractImageBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.IMAGE_BARRIER:
			{
				ImageBarrier imageBarrier = (ImageBarrier)theEObject;
				T1 result = caseImageBarrier(imageBarrier);
				if (result == null) result = caseAbstractImageBarrier(imageBarrier);
				if (result == null) result = casePipelineBarrier(imageBarrier);
				if (result == null) result = caseIProcessUnit(imageBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.REFERENCE_IMAGE_BARRIER:
			{
				ReferenceImageBarrier referenceImageBarrier = (ReferenceImageBarrier)theEObject;
				T1 result = caseReferenceImageBarrier(referenceImageBarrier);
				if (result == null) result = caseAbstractImageBarrier(referenceImageBarrier);
				if (result == null) result = casePipelineBarrier(referenceImageBarrier);
				if (result == null) result = caseIProcessUnit(referenceImageBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.IMAGE_TRANSITION:
			{
				ImageTransition imageTransition = (ImageTransition)theEObject;
				T1 result = caseImageTransition(imageTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_PIPELINE:
			{
				AbstractPipeline abstractPipeline = (AbstractPipeline)theEObject;
				T1 result = caseAbstractPipeline(abstractPipeline);
				if (result == null) result = caseIProcessUnit(abstractPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ABSTRACT_COMPOSITE_PIPELINE:
			{
				AbstractCompositePipeline abstractCompositePipeline = (AbstractCompositePipeline)theEObject;
				T1 result = caseAbstractCompositePipeline(abstractCompositePipeline);
				if (result == null) result = caseAbstractPipeline(abstractCompositePipeline);
				if (result == null) result = caseIProcessUnit(abstractCompositePipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.GRAPHICS_PIPELINE:
			{
				GraphicsPipeline graphicsPipeline = (GraphicsPipeline)theEObject;
				T1 result = caseGraphicsPipeline(graphicsPipeline);
				if (result == null) result = caseAbstractPipeline(graphicsPipeline);
				if (result == null) result = caseIProcessUnit(graphicsPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.COMPUTE_PIPELINE:
			{
				ComputePipeline computePipeline = (ComputePipeline)theEObject;
				T1 result = caseComputePipeline(computePipeline);
				if (result == null) result = caseAbstractPipeline(computePipeline);
				if (result == null) result = caseIProcessUnit(computePipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.COMPUTER:
			{
				Computer computer = (Computer)theEObject;
				T1 result = caseComputer(computer);
				if (result == null) result = caseIProcessUnit(computer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.IMAGE_PIPELINE:
			{
				ImagePipeline imagePipeline = (ImagePipeline)theEObject;
				T1 result = caseImagePipeline(imagePipeline);
				if (result == null) result = caseAbstractPipeline(imagePipeline);
				if (result == null) result = caseIProcessUnit(imagePipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.MESH_PIPELINE:
			{
				MeshPipeline meshPipeline = (MeshPipeline)theEObject;
				T1 result = caseMeshPipeline(meshPipeline);
				if (result == null) result = caseGraphicsPipeline(meshPipeline);
				if (result == null) result = caseAbstractPipeline(meshPipeline);
				if (result == null) result = caseIProcessUnit(meshPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConfiguration(Configuration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphic Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphic Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicConfiguration(GraphicConfiguration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Render Pass Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Render Pass Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRenderPassInfo(RenderPassInfo object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subpass Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subpass Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSubpassDependency(SubpassDependency object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attachment Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attachment Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAttachmentDescription(AttachmentDescription object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseColorDomain(ColorDomain object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Process Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Process Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends AbstractProcess> T1 caseAbstractProcessPool(AbstractProcessPool<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compute Process Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compute Process Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseComputeProcessPool(ComputeProcessPool object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphic Process Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphic Process Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicProcessPool(GraphicProcessPool object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractProcess(AbstractProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphic Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphic Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicProcess(GraphicProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compute Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compute Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseComputeProcess(ComputeProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProcess Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcess Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProcessUnit(IProcessUnit object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipeline Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipeline Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePipelineBarrier(PipelineBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBufferBarrier(BufferBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Image Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractImageBarrier(AbstractImageBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImageBarrier(ImageBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Image Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReferenceImageBarrier(ReferenceImageBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImageTransition(ImageTransition object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractPipeline(AbstractPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Composite Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Composite Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractCompositePipeline(AbstractCompositePipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphics Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphics Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicsPipeline(GraphicsPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compute Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compute Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseComputePipeline(ComputePipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseComputer(Computer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImagePipeline(ImagePipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mesh Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mesh Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMeshPipeline(MeshPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object)
	{
		return null;
	}

} //ProcessSwitch
