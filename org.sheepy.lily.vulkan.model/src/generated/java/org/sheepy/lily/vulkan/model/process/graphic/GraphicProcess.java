/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.joml.Vector3d;

import org.sheepy.lily.vulkan.model.process.AbstractProcess;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getRenderPassInfo <em>Render Pass Info</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getGraphicOffset <em>Graphic Offset</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getFieldOfViewY <em>Field Of View Y</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicProcess()
 * @model
 * @generated
 */
public interface GraphicProcess extends AbstractProcess
{
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(GraphicConfiguration)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicProcess_Configuration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	GraphicConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(GraphicConfiguration value);

	/**
	 * Returns the value of the '<em><b>Render Pass Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Render Pass Info</em>' containment reference.
	 * @see #setRenderPassInfo(RenderPassInfo)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicProcess_RenderPassInfo()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RenderPassInfo getRenderPassInfo();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getRenderPassInfo <em>Render Pass Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Pass Info</em>' containment reference.
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	void setRenderPassInfo(RenderPassInfo value);

	/**
	 * Returns the value of the '<em><b>Graphic Offset</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphic Offset</em>' attribute.
	 * @see #setGraphicOffset(Vector3d)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicProcess_GraphicOffset()
	 * @model default="0;0;0" unique="false" dataType="org.sheepy.lily.core.model.types.Vector3d"
	 * @generated
	 */
	Vector3d getGraphicOffset();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getGraphicOffset <em>Graphic Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphic Offset</em>' attribute.
	 * @see #getGraphicOffset()
	 * @generated
	 */
	void setGraphicOffset(Vector3d value);

	/**
	 * Returns the value of the '<em><b>Field Of View Y</b></em>' attribute.
	 * The default value is <code>"45"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Of View Y</em>' attribute.
	 * @see #setFieldOfViewY(float)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicProcess_FieldOfViewY()
	 * @model default="45" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='Field of View in degree ]0 ; 360['"
	 * @generated
	 */
	float getFieldOfViewY();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getFieldOfViewY <em>Field Of View Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Of View Y</em>' attribute.
	 * @see #getFieldOfViewY()
	 * @generated
	 */
	void setFieldOfViewY(float value);

} // GraphicProcess