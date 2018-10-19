/**
 */
package org.sheepy.vulkan.model.process;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.process.ProcessPackage
 * @generated
 */
public interface ProcessFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProcessFactory eINSTANCE = org.sheepy.vulkan.model.process.impl.ProcessFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Graphic Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graphic Configuration</em>'.
	 * @generated
	 */
	GraphicConfiguration createGraphicConfiguration();

	/**
	 * Returns a new object of class '<em>Render Pass Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Render Pass Info</em>'.
	 * @generated
	 */
	RenderPassInfo createRenderPassInfo();

	/**
	 * Returns a new object of class '<em>Subpass Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subpass Dependency</em>'.
	 * @generated
	 */
	SubpassDependency createSubpassDependency();

	/**
	 * Returns a new object of class '<em>Attachment Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attachment Description</em>'.
	 * @generated
	 */
	AttachmentDescription createAttachmentDescription();

	/**
	 * Returns a new object of class '<em>Color Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color Domain</em>'.
	 * @generated
	 */
	ColorDomain createColorDomain();

	/**
	 * Returns a new object of class '<em>Compute Process Pool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compute Process Pool</em>'.
	 * @generated
	 */
	ComputeProcessPool createComputeProcessPool();

	/**
	 * Returns a new object of class '<em>Graphic Process Pool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graphic Process Pool</em>'.
	 * @generated
	 */
	GraphicProcessPool createGraphicProcessPool();

	/**
	 * Returns a new object of class '<em>Graphic Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graphic Process</em>'.
	 * @generated
	 */
	GraphicProcess createGraphicProcess();

	/**
	 * Returns a new object of class '<em>Compute Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compute Process</em>'.
	 * @generated
	 */
	ComputeProcess createComputeProcess();

	/**
	 * Returns a new object of class '<em>Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Barrier</em>'.
	 * @generated
	 */
	BufferBarrier createBufferBarrier();

	/**
	 * Returns a new object of class '<em>Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Barrier</em>'.
	 * @generated
	 */
	ImageBarrier createImageBarrier();

	/**
	 * Returns a new object of class '<em>Reference Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Image Barrier</em>'.
	 * @generated
	 */
	ReferenceImageBarrier createReferenceImageBarrier();

	/**
	 * Returns a new object of class '<em>Image Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Transition</em>'.
	 * @generated
	 */
	ImageTransition createImageTransition();

	/**
	 * Returns a new object of class '<em>Compute Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compute Pipeline</em>'.
	 * @generated
	 */
	ComputePipeline createComputePipeline();

	/**
	 * Returns a new object of class '<em>Computer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computer</em>'.
	 * @generated
	 */
	Computer createComputer();

	/**
	 * Returns a new object of class '<em>Image Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Pipeline</em>'.
	 * @generated
	 */
	ImagePipeline createImagePipeline();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProcessPackage getProcessPackage();

} //ProcessFactory
