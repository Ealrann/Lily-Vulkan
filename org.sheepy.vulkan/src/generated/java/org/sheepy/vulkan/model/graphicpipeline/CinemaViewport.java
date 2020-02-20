/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cinema Viewport</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.CinemaViewport#getAspectRatio <em>Aspect Ratio</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.CinemaViewport#getMinDepth <em>Min Depth</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.CinemaViewport#getMaxDepth <em>Max Depth</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getCinemaViewport()
 * @model
 * @generated
 */
public interface CinemaViewport extends IViewport
{
	/**
	 * Returns the value of the '<em><b>Aspect Ratio</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspect Ratio</em>' attribute.
	 * @see #setAspectRatio(float)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getCinemaViewport_AspectRatio()
	 * @model default="1.0" required="true"
	 * @generated
	 */
	float getAspectRatio();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.CinemaViewport#getAspectRatio <em>Aspect Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aspect Ratio</em>' attribute.
	 * @see #getAspectRatio()
	 * @generated
	 */
	void setAspectRatio(float value);

	/**
	 * Returns the value of the '<em><b>Min Depth</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Depth</em>' attribute.
	 * @see #setMinDepth(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getCinemaViewport_MinDepth()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getMinDepth();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.CinemaViewport#getMinDepth <em>Min Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Depth</em>' attribute.
	 * @see #getMinDepth()
	 * @generated
	 */
	void setMinDepth(int value);

	/**
	 * Returns the value of the '<em><b>Max Depth</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Depth</em>' attribute.
	 * @see #setMaxDepth(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getCinemaViewport_MaxDepth()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getMaxDepth();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.CinemaViewport#getMaxDepth <em>Max Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Depth</em>' attribute.
	 * @see #getMaxDepth()
	 * @generated
	 */
	void setMaxDepth(int value);

} // CinemaViewport
