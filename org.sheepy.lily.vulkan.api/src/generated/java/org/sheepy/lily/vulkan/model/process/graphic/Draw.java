/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Draw</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getVertexCount <em>Vertex Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getFirstVertex <em>First Vertex</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getFirstInstance <em>First Instance</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDraw()
 * @model
 * @generated
 */
public interface Draw extends IPipelineTask
{

	/**
	 * Returns the value of the '<em><b>Vertex Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Count</em>' attribute.
	 * @see #setVertexCount(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDraw_VertexCount()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getVertexCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getVertexCount <em>Vertex Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Count</em>' attribute.
	 * @see #getVertexCount()
	 * @generated
	 */
	void setVertexCount(int value);

	/**
	 * Returns the value of the '<em><b>Instance Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Count</em>' attribute.
	 * @see #setInstanceCount(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDraw_InstanceCount()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(int value);

	/**
	 * Returns the value of the '<em><b>First Vertex</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Vertex</em>' attribute.
	 * @see #setFirstVertex(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDraw_FirstVertex()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getFirstVertex();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getFirstVertex <em>First Vertex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Vertex</em>' attribute.
	 * @see #getFirstVertex()
	 * @generated
	 */
	void setFirstVertex(int value);

	/**
	 * Returns the value of the '<em><b>First Instance</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Instance</em>' attribute.
	 * @see #setFirstInstance(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDraw_FirstInstance()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getFirstInstance();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getFirstInstance <em>First Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Instance</em>' attribute.
	 * @see #getFirstInstance()
	 * @generated
	 */
	void setFirstInstance(int value);
} // Draw
