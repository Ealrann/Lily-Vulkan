/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Viewport State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState#getViewportCount <em>Viewport Count</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState#getScissorCount <em>Scissor Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDynamicViewportState()
 * @model
 * @generated
 */
public interface DynamicViewportState extends ViewportState
{
	/**
	 * Returns the value of the '<em><b>Viewport Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewport Count</em>' attribute.
	 * @see #setViewportCount(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDynamicViewportState_ViewportCount()
	 * @model unique="false"
	 * @generated
	 */
	int getViewportCount();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState#getViewportCount <em>Viewport Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewport Count</em>' attribute.
	 * @see #getViewportCount()
	 * @generated
	 */
	void setViewportCount(int value);

	/**
	 * Returns the value of the '<em><b>Scissor Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scissor Count</em>' attribute.
	 * @see #setScissorCount(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDynamicViewportState_ScissorCount()
	 * @model unique="false"
	 * @generated
	 */
	int getScissorCount();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState#getScissorCount <em>Scissor Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scissor Count</em>' attribute.
	 * @see #getScissorCount()
	 * @generated
	 */
	void setScissorCount(int value);

} // DynamicViewportState
