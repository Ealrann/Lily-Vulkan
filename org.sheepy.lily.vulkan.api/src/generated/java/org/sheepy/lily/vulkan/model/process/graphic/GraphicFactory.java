/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage
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
	GraphicFactory eINSTANCE = org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	GraphicConfiguration createGraphicConfiguration();

	/**
	 * Returns a new object of class '<em>Color Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color Domain</em>'.
	 * @generated
	 */
	ColorDomain createColorDomain();

	/**
	 * Returns a new object of class '<em>Swapchain Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Swapchain Configuration</em>'.
	 * @generated
	 */
	SwapchainConfiguration createSwapchainConfiguration();

	/**
	 * Returns a new object of class '<em>Framebuffer Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Framebuffer Configuration</em>'.
	 * @generated
	 */
	FramebufferConfiguration createFramebufferConfiguration();

	/**
	 * Returns a new object of class '<em>Image Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Attachment</em>'.
	 * @generated
	 */
	ImageAttachment createImageAttachment();

	/**
	 * Returns a new object of class '<em>Depth Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Depth Attachment</em>'.
	 * @generated
	 */
	DepthAttachment createDepthAttachment();

	/**
	 * Returns a new object of class '<em>Attachment Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attachment Pkg</em>'.
	 * @generated
	 */
	AttachmentPkg createAttachmentPkg();

	/**
	 * Returns a new object of class '<em>Subpass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subpass</em>'.
	 * @generated
	 */
	Subpass createSubpass();

	/**
	 * Returns a new object of class '<em>Attachment Ref Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attachment Ref Pkg</em>'.
	 * @generated
	 */
	AttachmentRefPkg createAttachmentRefPkg();

	/**
	 * Returns a new object of class '<em>Attachment Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attachment Ref</em>'.
	 * @generated
	 */
	AttachmentRef createAttachmentRef();

	/**
	 * Returns a new object of class '<em>Swap Image Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Swap Image Attachment</em>'.
	 * @generated
	 */
	SwapImageAttachment createSwapImageAttachment();

	/**
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	GraphicProcess createGraphicProcess();

	/**
	 * Returns a new object of class '<em>Graphics Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graphics Pipeline</em>'.
	 * @generated
	 */
	GraphicsPipeline createGraphicsPipeline();

	/**
	 * Returns a new object of class '<em>Swap Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Swap Image Barrier</em>'.
	 * @generated
	 */
	SwapImageBarrier createSwapImageBarrier();

	/**
	 * Returns a new object of class '<em>Blit To Swap Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Blit To Swap Image</em>'.
	 * @generated
	 */
	BlitToSwapImage createBlitToSwapImage();

	/**
	 * Returns a new object of class '<em>Draw Indexed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Draw Indexed</em>'.
	 * @generated
	 */
	DrawIndexed createDrawIndexed();

	/**
	 * Returns a new object of class '<em>Draw</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Draw</em>'.
	 * @generated
	 */
	Draw createDraw();

	/**
	 * Returns a new object of class '<em>Vertex Input State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vertex Input State</em>'.
	 * @generated
	 */
	VertexInputState createVertexInputState();

	/**
	 * Returns a new object of class '<em>Input Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Descriptor</em>'.
	 * @generated
	 */
	InputDescriptor createInputDescriptor();

	/**
	 * Returns a new object of class '<em>Attribute Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Description</em>'.
	 * @generated
	 */
	AttributeDescription createAttributeDescription();

	/**
	 * Returns a new object of class '<em>Bind Vertex Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bind Vertex Buffer</em>'.
	 * @generated
	 */
	BindVertexBuffer createBindVertexBuffer();

	/**
	 * Returns a new object of class '<em>Set Scissor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Scissor</em>'.
	 * @generated
	 */
	SetScissor createSetScissor();

	/**
	 * Returns a new object of class '<em>Set Viewport</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Viewport</em>'.
	 * @generated
	 */
	SetViewport createSetViewport();

	/**
	 * Returns a new object of class '<em>Vertex Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vertex Binding</em>'.
	 * @generated
	 */
	VertexBinding createVertexBinding();

	/**
	 * Returns a new object of class '<em>Bind Index Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bind Index Buffer</em>'.
	 * @generated
	 */
	BindIndexBuffer createBindIndexBuffer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GraphicPackage getGraphicPackage();

} //GraphicFactory
