/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Draw Indexed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getIndexCount <em>Index Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getFirstIndex <em>First Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getVertexOffset <em>Vertex Offset</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getFirstInstance <em>First Instance</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDrawIndexed()
 * @model
 * @generated
 */
public interface DrawIndexed extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Index Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Count</em>' attribute.
	 * @see #setIndexCount(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDrawIndexed_IndexCount()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getIndexCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getIndexCount <em>Index Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Count</em>' attribute.
	 * @see #getIndexCount()
	 * @generated
	 */
	void setIndexCount(int value);

	/**
	 * Returns the value of the '<em><b>Instance Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Count</em>' attribute.
	 * @see #setInstanceCount(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDrawIndexed_InstanceCount()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(int value);

	/**
	 * Returns the value of the '<em><b>First Index</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Index</em>' attribute.
	 * @see #setFirstIndex(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDrawIndexed_FirstIndex()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getFirstIndex();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getFirstIndex <em>First Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Index</em>' attribute.
	 * @see #getFirstIndex()
	 * @generated
	 */
	void setFirstIndex(int value);

	/**
	 * Returns the value of the '<em><b>Vertex Offset</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Offset</em>' attribute.
	 * @see #setVertexOffset(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDrawIndexed_VertexOffset()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getVertexOffset();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getVertexOffset <em>Vertex Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Offset</em>' attribute.
	 * @see #getVertexOffset()
	 * @generated
	 */
	void setVertexOffset(int value);

	/**
	 * Returns the value of the '<em><b>First Instance</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Instance</em>' attribute.
	 * @see #setFirstInstance(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDrawIndexed_FirstInstance()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getFirstInstance();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getFirstInstance <em>First Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Instance</em>' attribute.
	 * @see #getFirstInstance()
	 * @generated
	 */
	void setFirstInstance(int value);

} // DrawIndexed
