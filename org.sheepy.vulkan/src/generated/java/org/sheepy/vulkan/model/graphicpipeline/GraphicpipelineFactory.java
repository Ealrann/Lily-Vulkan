/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage
 * @generated
 */
public interface GraphicpipelineFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphicpipelineFactory eINSTANCE = org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelineFactoryImpl.init();

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
	 * Returns a new object of class '<em>Input Assembly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Assembly</em>'.
	 * @generated
	 */
	InputAssembly createInputAssembly();

	/**
	 * Returns a new object of class '<em>Rasterizer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rasterizer</em>'.
	 * @generated
	 */
	Rasterizer createRasterizer();

	/**
	 * Returns a new object of class '<em>Dynamic State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic State</em>'.
	 * @generated
	 */
	DynamicState createDynamicState();

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
	 * Returns a new object of class '<em>Cinema Viewport</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cinema Viewport</em>'.
	 * @generated
	 */
	CinemaViewport createCinemaViewport();

	/**
	 * Returns a new object of class '<em>Scissor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scissor</em>'.
	 * @generated
	 */
	Scissor createScissor();

	/**
	 * Returns a new object of class '<em>Depth Stencil State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Depth Stencil State</em>'.
	 * @generated
	 */
	DepthStencilState createDepthStencilState();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GraphicpipelinePackage getGraphicpipelinePackage();

} //GraphicpipelineFactory
