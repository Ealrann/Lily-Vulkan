/**
 */
package org.sheepy.vulkan.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.vulkan.model.*;

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
 * @see org.sheepy.vulkan.model.VulkanPackage
 * @generated
 */
public class VulkanSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VulkanPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = VulkanPackage.eINSTANCE;
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
			case VulkanPackage.VULKAN_APPLICATION:
			{
				VulkanApplication vulkanApplication = (VulkanApplication)theEObject;
				T1 result = caseVulkanApplication(vulkanApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.CONFIGURATION:
			{
				Configuration configuration = (Configuration)theEObject;
				T1 result = caseConfiguration(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.GRAPHIC_CONFIGURATION:
			{
				GraphicConfiguration graphicConfiguration = (GraphicConfiguration)theEObject;
				T1 result = caseGraphicConfiguration(graphicConfiguration);
				if (result == null) result = caseConfiguration(graphicConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.RENDER_PASS_INFO:
			{
				RenderPassInfo renderPassInfo = (RenderPassInfo)theEObject;
				T1 result = caseRenderPassInfo(renderPassInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.SUBPASS_DEPENDENCY:
			{
				SubpassDependency subpassDependency = (SubpassDependency)theEObject;
				T1 result = caseSubpassDependency(subpassDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.ATTACHMENT_DESCRIPTION:
			{
				AttachmentDescription attachmentDescription = (AttachmentDescription)theEObject;
				T1 result = caseAttachmentDescription(attachmentDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.COLOR_DOMAIN:
			{
				ColorDomain colorDomain = (ColorDomain)theEObject;
				T1 result = caseColorDomain(colorDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.ABSTRACT_PROCESS_POOL:
			{
				AbstractProcessPool<?> abstractProcessPool = (AbstractProcessPool<?>)theEObject;
				T1 result = caseAbstractProcessPool(abstractProcessPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.COMPUTE_PROCESS_POOL:
			{
				ComputeProcessPool computeProcessPool = (ComputeProcessPool)theEObject;
				T1 result = caseComputeProcessPool(computeProcessPool);
				if (result == null) result = caseAbstractProcessPool(computeProcessPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.GRAPHIC_PROCESS_POOL:
			{
				GraphicProcessPool graphicProcessPool = (GraphicProcessPool)theEObject;
				T1 result = caseGraphicProcessPool(graphicProcessPool);
				if (result == null) result = caseAbstractProcessPool(graphicProcessPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.ABSTRACT_PROCESS:
			{
				AbstractProcess abstractProcess = (AbstractProcess)theEObject;
				T1 result = caseAbstractProcess(abstractProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.GRAPHIC_PROCESS:
			{
				GraphicProcess graphicProcess = (GraphicProcess)theEObject;
				T1 result = caseGraphicProcess(graphicProcess);
				if (result == null) result = caseAbstractProcess(graphicProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.COMPUTE_PROCESS:
			{
				ComputeProcess computeProcess = (ComputeProcess)theEObject;
				T1 result = caseComputeProcess(computeProcess);
				if (result == null) result = caseAbstractProcess(computeProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.IPROCESS_UNIT:
			{
				IProcessUnit iProcessUnit = (IProcessUnit)theEObject;
				T1 result = caseIProcessUnit(iProcessUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.PIPELINE_BARRIER:
			{
				PipelineBarrier pipelineBarrier = (PipelineBarrier)theEObject;
				T1 result = casePipelineBarrier(pipelineBarrier);
				if (result == null) result = caseIProcessUnit(pipelineBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.BUFFER_BARRIER:
			{
				BufferBarrier bufferBarrier = (BufferBarrier)theEObject;
				T1 result = caseBufferBarrier(bufferBarrier);
				if (result == null) result = casePipelineBarrier(bufferBarrier);
				if (result == null) result = caseIProcessUnit(bufferBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.ABSTRACT_IMAGE_BARRIER:
			{
				AbstractImageBarrier abstractImageBarrier = (AbstractImageBarrier)theEObject;
				T1 result = caseAbstractImageBarrier(abstractImageBarrier);
				if (result == null) result = casePipelineBarrier(abstractImageBarrier);
				if (result == null) result = caseIProcessUnit(abstractImageBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.IMAGE_BARRIER:
			{
				ImageBarrier imageBarrier = (ImageBarrier)theEObject;
				T1 result = caseImageBarrier(imageBarrier);
				if (result == null) result = caseAbstractImageBarrier(imageBarrier);
				if (result == null) result = casePipelineBarrier(imageBarrier);
				if (result == null) result = caseIProcessUnit(imageBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.REFERENCE_IMAGE_BARRIER:
			{
				ReferenceImageBarrier referenceImageBarrier = (ReferenceImageBarrier)theEObject;
				T1 result = caseReferenceImageBarrier(referenceImageBarrier);
				if (result == null) result = caseAbstractImageBarrier(referenceImageBarrier);
				if (result == null) result = casePipelineBarrier(referenceImageBarrier);
				if (result == null) result = caseIProcessUnit(referenceImageBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.IMAGE_TRANSITION:
			{
				ImageTransition imageTransition = (ImageTransition)theEObject;
				T1 result = caseImageTransition(imageTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.IDESCRIPTOR:
			{
				IDescriptor iDescriptor = (IDescriptor)theEObject;
				T1 result = caseIDescriptor(iDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.DESCRIPTOR_SET:
			{
				DescriptorSet descriptorSet = (DescriptorSet)theEObject;
				T1 result = caseDescriptorSet(descriptorSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.ABSTRACT_PIPELINE:
			{
				AbstractPipeline abstractPipeline = (AbstractPipeline)theEObject;
				T1 result = caseAbstractPipeline(abstractPipeline);
				if (result == null) result = caseIProcessUnit(abstractPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.ABSTRACT_COMPOSITE_PIPELINE:
			{
				AbstractCompositePipeline abstractCompositePipeline = (AbstractCompositePipeline)theEObject;
				T1 result = caseAbstractCompositePipeline(abstractCompositePipeline);
				if (result == null) result = caseAbstractPipeline(abstractCompositePipeline);
				if (result == null) result = caseIProcessUnit(abstractCompositePipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.GRAPHICS_PIPELINE:
			{
				GraphicsPipeline graphicsPipeline = (GraphicsPipeline)theEObject;
				T1 result = caseGraphicsPipeline(graphicsPipeline);
				if (result == null) result = caseAbstractPipeline(graphicsPipeline);
				if (result == null) result = caseIProcessUnit(graphicsPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.COMPUTE_PIPELINE:
			{
				ComputePipeline computePipeline = (ComputePipeline)theEObject;
				T1 result = caseComputePipeline(computePipeline);
				if (result == null) result = caseAbstractPipeline(computePipeline);
				if (result == null) result = caseIProcessUnit(computePipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.COMPUTER:
			{
				Computer computer = (Computer)theEObject;
				T1 result = caseComputer(computer);
				if (result == null) result = caseIProcessUnit(computer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.IMAGE_PIPELINE:
			{
				ImagePipeline imagePipeline = (ImagePipeline)theEObject;
				T1 result = caseImagePipeline(imagePipeline);
				if (result == null) result = caseAbstractPipeline(imagePipeline);
				if (result == null) result = caseIProcessUnit(imagePipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.MESH_PIPELINE:
			{
				MeshPipeline meshPipeline = (MeshPipeline)theEObject;
				T1 result = caseMeshPipeline(meshPipeline);
				if (result == null) result = caseGraphicsPipeline(meshPipeline);
				if (result == null) result = caseAbstractPipeline(meshPipeline);
				if (result == null) result = caseIProcessUnit(meshPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.RESOURCE:
			{
				Resource resource = (Resource)theEObject;
				T1 result = caseResource(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.VULKAN_BUFFER:
			{
				VulkanBuffer vulkanBuffer = (VulkanBuffer)theEObject;
				T1 result = caseVulkanBuffer(vulkanBuffer);
				if (result == null) result = caseResource(vulkanBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.BUFFER:
			{
				Buffer buffer = (Buffer)theEObject;
				T1 result = caseBuffer(buffer);
				if (result == null) result = caseVulkanBuffer(buffer);
				if (result == null) result = caseResource(buffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.SIZED_BUFFER:
			{
				SizedBuffer sizedBuffer = (SizedBuffer)theEObject;
				T1 result = caseSizedBuffer(sizedBuffer);
				if (result == null) result = caseVulkanBuffer(sizedBuffer);
				if (result == null) result = caseResource(sizedBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.IMAGE:
			{
				Image image = (Image)theEObject;
				T1 result = caseImage(image);
				if (result == null) result = caseSizedBuffer(image);
				if (result == null) result = caseVulkanBuffer(image);
				if (result == null) result = caseResource(image);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.TEXTURE:
			{
				Texture texture = (Texture)theEObject;
				T1 result = caseTexture(texture);
				if (result == null) result = caseVulkanBuffer(texture);
				if (result == null) result = caseIDescriptor(texture);
				if (result == null) result = caseResource(texture);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.DEPTH_IMAGE:
			{
				DepthImage depthImage = (DepthImage)theEObject;
				T1 result = caseDepthImage(depthImage);
				if (result == null) result = caseVulkanBuffer(depthImage);
				if (result == null) result = caseResource(depthImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.PATH_RESOURCE:
			{
				PathResource pathResource = (PathResource)theEObject;
				T1 result = casePathResource(pathResource);
				if (result == null) result = caseResource(pathResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.FILE_RESOURCE:
			{
				FileResource fileResource = (FileResource)theEObject;
				T1 result = caseFileResource(fileResource);
				if (result == null) result = casePathResource(fileResource);
				if (result == null) result = caseResource(fileResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.MODULE_RESOURCE:
			{
				ModuleResource moduleResource = (ModuleResource)theEObject;
				T1 result = caseModuleResource(moduleResource);
				if (result == null) result = casePathResource(moduleResource);
				if (result == null) result = caseResource(moduleResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.SHADER:
			{
				Shader shader = (Shader)theEObject;
				T1 result = caseShader(shader);
				if (result == null) result = caseResource(shader);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.PUSH_CONSTANT:
			{
				PushConstant pushConstant = (PushConstant)theEObject;
				T1 result = casePushConstant(pushConstant);
				if (result == null) result = caseVulkanBuffer(pushConstant);
				if (result == null) result = caseResource(pushConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.INDEXED_BUFFER:
			{
				IndexedBuffer indexedBuffer = (IndexedBuffer)theEObject;
				T1 result = caseIndexedBuffer(indexedBuffer);
				if (result == null) result = caseVulkanBuffer(indexedBuffer);
				if (result == null) result = caseIDescriptor(indexedBuffer);
				if (result == null) result = caseResource(indexedBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.MESH_BUFFER:
			{
				MeshBuffer meshBuffer = (MeshBuffer)theEObject;
				T1 result = caseMeshBuffer(meshBuffer);
				if (result == null) result = caseIndexedBuffer(meshBuffer);
				if (result == null) result = caseVulkanBuffer(meshBuffer);
				if (result == null) result = caseIDescriptor(meshBuffer);
				if (result == null) result = caseResource(meshBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.UNIFORM_BUFFER:
			{
				UniformBuffer uniformBuffer = (UniformBuffer)theEObject;
				T1 result = caseUniformBuffer(uniformBuffer);
				if (result == null) result = caseVulkanBuffer(uniformBuffer);
				if (result == null) result = caseIDescriptor(uniformBuffer);
				if (result == null) result = caseResource(uniformBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.BOARD_BUFFER:
			{
				BoardBuffer boardBuffer = (BoardBuffer)theEObject;
				T1 result = caseBoardBuffer(boardBuffer);
				if (result == null) result = caseVulkanBuffer(boardBuffer);
				if (result == null) result = caseIDescriptor(boardBuffer);
				if (result == null) result = caseResource(boardBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.BOARD_IMAGE:
			{
				BoardImage boardImage = (BoardImage)theEObject;
				T1 result = caseBoardImage(boardImage);
				if (result == null) result = caseImage(boardImage);
				if (result == null) result = caseIDescriptor(boardImage);
				if (result == null) result = caseSizedBuffer(boardImage);
				if (result == null) result = caseVulkanBuffer(boardImage);
				if (result == null) result = caseResource(boardImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVulkanApplication(VulkanApplication object)
	{
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>IDescriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDescriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIDescriptor(IDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDescriptorSet(DescriptorSet object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResource(Resource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVulkanBuffer(VulkanBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBuffer(Buffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sized Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sized Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSizedBuffer(SizedBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImage(Image object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Texture</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Texture</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTexture(Texture object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Depth Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Depth Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDepthImage(DepthImage object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePathResource(PathResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFileResource(FileResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModuleResource(ModuleResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shader</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shader</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseShader(Shader object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Push Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Push Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePushConstant(PushConstant object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Indexed Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Indexed Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIndexedBuffer(IndexedBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mesh Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mesh Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMeshBuffer(MeshBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uniform Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uniform Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUniformBuffer(UniformBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Board Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Board Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBoardBuffer(BoardBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Board Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Board Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBoardImage(BoardImage object)
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

} //VulkanSwitch
