/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Viewport</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getX <em>X</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getY <em>Y</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getMinDepth <em>Min Depth</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getMaxDepth <em>Max Depth</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetViewport()
 * @model
 * @generated
 */
public interface SetViewport extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(float)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetViewport_X()
	 * @model default="0" unique="false"
	 * @generated
	 */
	float getX();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(float value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(float)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetViewport_Y()
	 * @model default="0" unique="false"
	 * @generated
	 */
	float getY();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(float value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(float)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetViewport_Width()
	 * @model unique="false"
	 * @generated
	 */
	float getWidth();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(float value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(float)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetViewport_Height()
	 * @model unique="false"
	 * @generated
	 */
	float getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(float value);

	/**
	 * Returns the value of the '<em><b>Min Depth</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Depth</em>' attribute.
	 * @see #setMinDepth(float)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetViewport_MinDepth()
	 * @model default="1" unique="false"
	 * @generated
	 */
	float getMinDepth();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getMinDepth <em>Min Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Depth</em>' attribute.
	 * @see #getMinDepth()
	 * @generated
	 */
	void setMinDepth(float value);

	/**
	 * Returns the value of the '<em><b>Max Depth</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Depth</em>' attribute.
	 * @see #setMaxDepth(float)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetViewport_MaxDepth()
	 * @model default="1" unique="false"
	 * @generated
	 */
	float getMaxDepth();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getMaxDepth <em>Max Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Depth</em>' attribute.
	 * @see #getMaxDepth()
	 * @generated
	 */
	void setMaxDepth(float value);

} // SetViewport
