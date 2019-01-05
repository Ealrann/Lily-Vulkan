/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage
 * @generated
 */
public interface GraphicFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphicFactory eINSTANCE = org.sheepy.vulkan.model.process.graphic.impl.GraphicFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
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
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	GraphicProcess createGraphicProcess();

	/**
	 * Returns a new object of class '<em>Dynamic State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic State</em>'.
	 * @generated
	 */
	DynamicState createDynamicState();

	/**
	 * Returns a new object of class '<em>Color Blend</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color Blend</em>'.
	 * @generated
	 */
	ColorBlend createColorBlend();

	/**
	 * Returns a new object of class '<em>Color Blend Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color Blend Attachment</em>'.
	 * @generated
	 */
	ColorBlendAttachment createColorBlendAttachment();

	/**
	 * Returns a new object of class '<em>Static Viewport State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Viewport State</em>'.
	 * @generated
	 */
	StaticViewportState createStaticViewportState();

	/**
	 * Returns a new object of class '<em>Dynamic Viewport State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Viewport State</em>'.
	 * @generated
	 */
	DynamicViewportState createDynamicViewportState();

	/**
	 * Returns a new object of class '<em>Viewport</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Viewport</em>'.
	 * @generated
	 */
	Viewport createViewport();

	/**
	 * Returns a new object of class '<em>Scissor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scissor</em>'.
	 * @generated
	 */
	Scissor createScissor();

	/**
	 * Returns a new object of class '<em>Rasterizer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rasterizer</em>'.
	 * @generated
	 */
	Rasterizer createRasterizer();

	/**
	 * Returns a new object of class '<em>Image Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Pipeline</em>'.
	 * @generated
	 */
	ImagePipeline createImagePipeline();

	/**
	 * Returns a new object of class '<em>Pipeline Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipeline Image Barrier</em>'.
	 * @generated
	 */
	PipelineImageBarrier createPipelineImageBarrier();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GraphicPackage getGraphicPackage();

} //GraphicFactory